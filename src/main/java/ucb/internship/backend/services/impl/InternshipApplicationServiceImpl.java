package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.dtos.InternshipApplicationDto;
import ucb.internship.backend.dtos.InternshipApplicationQuestionDto;
import ucb.internship.backend.dtos.NotificationDto;
import ucb.internship.backend.mailing.EmailVariables;
import ucb.internship.backend.mailing.Recipient;
import ucb.internship.backend.mailing.Template;
import ucb.internship.backend.models.*;
import ucb.internship.backend.repositories.InternshipApplicationQuestionRepository;
import ucb.internship.backend.repositories.InternshipApplicationRepository;
import ucb.internship.backend.repositories.InternshipRepository;
import ucb.internship.backend.repositories.PersonRepository;
import ucb.internship.backend.services.EmailService;
import ucb.internship.backend.services.InternshipApplicationService;
import ucb.internship.backend.services.PushNotificationsService;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class InternshipApplicationServiceImpl implements InternshipApplicationService {
    @Autowired
    private InternshipApplicationRepository internshipApplicationRepository;
    @Autowired
    private InternshipApplicationQuestionRepository internshipApplicationQuestionRepository;
    @Autowired
    private InternshipRepository internshipRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PushNotificationsService pushNotificationsService;

    @Override
    public InternshipApplicationDto applyToInternship(InternshipApplicationDto internshipApplicationDto) {
        Internship internship = internshipRepository.findById(internshipApplicationDto.getInternshipId()).orElseThrow(() -> new RuntimeException("Internship not found"));
        Person person = personRepository.findById(internshipApplicationDto.getPersonId()).orElseThrow(() -> new RuntimeException("Person not found"));

        List<InternshipQuestion> internshipQuestions = internship.getInternshipQuestions();
        Map<Long, InternshipQuestion> internshipQuestionMap = internshipQuestions.stream().collect(Collectors.toMap(InternshipQuestion::getInternshipQuestionId, internshipQuestion -> internshipQuestion));

        InternshipApplication internshipApplication = new InternshipApplication();
        internshipApplication.setInternship(internship);
        internshipApplication.setPerson(person);
        internshipApplication.setAdmitted(0);
        internshipApplication.setStatus(true);
        internshipApplication.setSubmittedOn(new java.sql.Date(System.currentTimeMillis()));
        List<InternshipApplicationQuestion> questionList = new ArrayList<>();
        for (InternshipApplicationQuestionDto questionDto : internshipApplicationDto.getInternshipApplicationQuestions()) {
            InternshipApplicationQuestion internshipApplicationQuestion = new InternshipApplicationQuestion();
            internshipApplicationQuestion.setInternship(internship);
            internshipApplicationQuestion.setInternshipApplication(internshipApplication);
            internshipApplicationQuestion.setInternshipQuestion(internshipQuestionMap.get(questionDto.getQuestionId()));
            internshipApplicationQuestion.setResponse(questionDto.getResponse());
            internshipApplicationQuestion.setStatus(true);
            questionList.add(internshipApplicationQuestion);
        }
        internshipApplicationRepository.save(internshipApplication);
        internshipApplicationQuestionRepository.saveAll(questionList);
        return internshipApplicationDto;
    }

    @Override
    public Boolean updateApplicationStatus(Long internshipId, Long applicationId, Integer status, String message) {
        internshipRepository.findById(internshipId).orElseThrow(() -> new RuntimeException("Internship not found"));
        InternshipApplication internshipApplication = internshipApplicationRepository.findById(applicationId).orElseThrow(() -> new RuntimeException("Internship application not found"));
        internshipApplication.setAdmitted(status);
        internshipApplicationRepository.save(internshipApplication);

        notifyApplicant(internshipApplication, message);

        return true;
    }

    private void notifyApplicant(InternshipApplication application, String message) {

        var person = application.getPerson();
        Recipient recipient = new Recipient(person.getUserUcb().getEmail(), person.getFirstName() + " " + person.getLastName());
        var mailVariables = new Hashtable<String, String>();
        mailVariables.put(EmailVariables.APPLICATION_TITLE.get(), application.getInternship().getTitle());
        mailVariables.put(EmailVariables.APPLICATION_EMPLOYER.get(), application.getInternship().getInstitution().getName());
        mailVariables.put(EmailVariables.APPLICATION_STATUS.get(), application.getAdmitted() == 1 ? "Aceptada" : "Rechazada");
        mailVariables.put(EmailVariables.APPLICATION_MESSAGE.get(), message);

        emailService.sendEmail(recipient, mailVariables , Template.INTERNSHIP_APPLICATION_UPDATE);

        var notification = new NotificationDto<InternshipApplication>(
                "",
                "Verifique su correo por la postulación "+ application.getInternship().getTitle(),
                new Timestamp(new Date().getTime()),
                "");

        pushNotificationsService.push(notification, person.getUserUcb().getUserId().toString());
    }
}
