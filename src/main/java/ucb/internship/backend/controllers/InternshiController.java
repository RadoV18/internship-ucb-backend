package ucb.internship.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.ActiveInternshipDto;
import ucb.internship.backend.dtos.ApplicantDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.services.InternshipService;
import ucb.internship.backend.dtos.InternshipDTO;
import ucb.internship.backend.models.Internship;

import java.util.List;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "*")
public class InternshiController {
    @Autowired
    private InternshipService internshipService;
    public static final Logger LOGGER = LoggerFactory.getLogger(InternshiController.class);

    @PostMapping
    public String createInternship(@RequestBody InternshipDTO internshipDto){
        LOGGER.info("Creating internship {}", internshipDto);
        return internshipService.createInternship(internshipDto);
    }

    @GetMapping("/{id}")
    public List<Internship> getInternship(@PathVariable Integer id){
        return internshipService.getInternshipById(id);
    }

    @GetMapping("/institution/{id}/active")
    public ResponseEntity<ResponseDto<List<ActiveInternshipDto>>> getActiveInternshipsByInstitutionId(
        @PathVariable Integer id
    ) {
        List<ActiveInternshipDto> internships = internshipService.getActiveInternshipsByInstitutionId(id);
        return ResponseEntity.ok(new ResponseDto<>(internships, null, true));
    }

    @GetMapping("/{id}/applicants")
    public ResponseEntity<ResponseDto<List<ApplicantDto>>> getApplicantsByInternshipId (
        @PathVariable Integer id
    ) {
        List<ApplicantDto> applicants = internshipService.getApplicantsByInternshipId(id);
        return ResponseEntity.ok(new ResponseDto<>(applicants, null, true));
    }

}
