package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.dtos.InternshipApplicationDto;
import ucb.internship.backend.dtos.InternshipApplicationQuestionDto;
import ucb.internship.backend.models.*;
import ucb.internship.backend.repositories.InternshipApplicationQuestionRepository;
import ucb.internship.backend.repositories.InternshipApplicationRepository;
import ucb.internship.backend.repositories.InternshipRepository;
import ucb.internship.backend.repositories.PersonRepository;
import ucb.internship.backend.services.InternshipApplicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        // TODO: Send email to applicant
        return true;
    }
}
