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
import ucb.internship.backend.services.InternshipApplicationService;

@RestController
@RequestMapping("/api/internshipapplications")
@CrossOrigin(origins = "*")
public class InternshipApplicationController {
    @Autowired
    private InternshipApplicationService internshipApplicationService;

    @PostMapping()
    public ResponseEntity<InternshipApplicationDto> postPersonSkillDto(
            @RequestBody InternshipApplicationDto internshipApplicationDto) {
        InternshipApplicationDto response = internshipApplicationService.postPersonSkill(internshipApplicationDto);
        return new ResponseEntity<InternshipApplicationDto>(response, HttpStatus.OK);
    }
}
