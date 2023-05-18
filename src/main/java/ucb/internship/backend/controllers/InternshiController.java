
package ucb.internship.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.*;
import ucb.internship.backend.services.InternshipService;
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
    public ResponseEntity<ResponseDto<Void>> createInternship(@RequestBody InternshipDto internshipDto){
        LOGGER.info("Creating internship {}", internshipDto);
        internshipService.createInternship(internshipDto);
        return ResponseEntity.ok(new ResponseDto<>(null, "Convocatoria creada exitosamente.", true));
    }

    @GetMapping("/institution/{id}/active")
    public ResponseEntity<ResponseDto<List<ActiveInternshipDto>>> getActiveInternshipsByInstitutionId(
        @PathVariable Long id
    ) {
        List<ActiveInternshipDto> internships = internshipService.getActiveInternshipsByInstitutionId(id);
        return ResponseEntity.ok(new ResponseDto<>(internships, null, true));
    }

    @GetMapping("/{id}/applicants")
    public ResponseEntity<ResponseDto<List<ApplicantDto>>> getApplicantsByInternshipId(
            @PathVariable Integer id) {
        List<ApplicantDto> applicants = internshipService.getApplicantsByInternshipId(id);
        return ResponseEntity.ok(new ResponseDto<>(applicants, null, true));
    }

    @GetMapping("/internship/{id}")
    public ResponseEntity<ResponseDto<InternshipApiDto>> getInternship(@PathVariable Integer id) {
        return ResponseEntity.ok(new ResponseDto<>(internshipService.getInternshipApiById(id), null, true));
    }

    @GetMapping("/internship")
    public ResponseEntity<ResponseDto<List<InternshipApiDto>>> getInternshipAll() {
        return ResponseEntity.ok(new ResponseDto<>(internshipService.getInternshipAll(), null, true));
    }

    @PutMapping("/internship/{state}/{id}")
    public ResponseEntity<ResponseDto<InternshipApiDto>> internshipAccepted(@PathVariable Integer id, @PathVariable Integer state) {
        internshipService.internShipChangeAprovedState(id, state);
        return ResponseEntity.ok(new ResponseDto<>(internshipService.getInternshipApiById(id), null, true));
    }

}
