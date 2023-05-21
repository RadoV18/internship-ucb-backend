package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.dtos.InternshipApplicationDto;
import ucb.internship.backend.models.InternshipApplication;
import ucb.internship.backend.models.InternshipApplicationQuestion;
import ucb.internship.backend.repositories.InternshipApplicationQuestionRepository;
import ucb.internship.backend.repositories.InternshipApplicationRepository;
import ucb.internship.backend.services.InternshipApplicationService;

@Service
public class InternshipApplicationServiceImpl implements InternshipApplicationService {
    @Autowired
    private InternshipApplicationRepository internshipApplicationRepository;
    @Autowired
    private InternshipApplicationQuestionRepository internshipApplicationQuestionRepository;

    @Override
    public InternshipApplicationDto postPersonSkill(InternshipApplicationDto internshipApplicationDto) {
        InternshipApplication internshipApplication = internshipApplicationRepository
                .save(new InternshipApplication(null, internshipApplicationDto.getInternshipId(),
                        internshipApplicationDto.getPersonId(), new java.sql.Date(0), Integer.valueOf(0),
                        Boolean.valueOf(true)));

        internshipApplicationDto.getInternshipApplicationQuestionDtos().forEach((internshipApplicationQuestionDto) -> {
            internshipApplicationQuestionRepository
                    .save(new InternshipApplicationQuestion(internshipApplicationQuestionDto.getInternshipId(),
                            internshipApplicationQuestionDto.getInternshipQuestionId(),
                            internshipApplication.getInternshipApplicationId(),
                            internshipApplicationQuestionDto.getResponse()));
        });
        return new InternshipApplicationDto(null, null, null, null, null, null, null);
    }
}
