package ucb.internship.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.dtos.InternshipApplicationDto;
import ucb.internship.backend.models.InternshipApplication;
import ucb.internship.backend.models.InternshipApplicationQuestion;
import ucb.internship.backend.repositories.InternshipApplicationQuestionRepository;
import ucb.internship.backend.repositories.InternshipApplicationRepository;

@RestController
@RequestMapping("/api/internshipapplications")
@CrossOrigin(origins = "*")
public class InternshipApplicationController {
    @Autowired
    private InternshipApplicationRepository internshipApplicationRepository;
    @Autowired
    private InternshipApplicationQuestionRepository internshipApplicationQuestionRepository;

    @PostMapping()
    public ResponseEntity<InternshipApplication> postPersonSkill(
            @RequestBody InternshipApplicationDto internshipApplicationDto) {
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
        return new ResponseEntity<InternshipApplication>(internshipApplication, HttpStatus.OK);
    }
}
