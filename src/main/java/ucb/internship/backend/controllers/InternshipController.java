package ucb.internship.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.*;
import ucb.internship.backend.services.InternshipApplicationService;
import ucb.internship.backend.services.InternshipService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {
    @Autowired
    private InternshipService internshipService;
    @Autowired
    private InternshipApplicationService internshipApplicationService;
    public static final Logger LOGGER = LoggerFactory.getLogger(InternshipController.class);

    @PostMapping
    public ResponseEntity<ResponseDto<Void>> createInternship(@RequestBody InternshipDto internshipDto) {
        LOGGER.info("Creating internship {}", internshipDto);
        internshipService.createInternship(internshipDto);
        return ResponseEntity.ok(new ResponseDto<>(null, "Convocatoria creada exitosamente.", true));
    }

    @GetMapping
    @PreAuthorize("hasRole('STUDENT') or hasRole('GRADUATE')")
    public ResponseEntity<ResponseDto<Page<InternshipListDto>>> getInternship(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String major,
            @RequestParam(required = false) Date startingDate,
            @RequestParam(required = false) Date endingDate,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {
        try {
            LOGGER.info(
                    "starting get internship list with parameters city: {}, major: {}, startingDate: {}, endingDate: {}, page: {}, size: {}",
                    city, major, startingDate, endingDate, page, size);
            Page<InternshipListDto> internshipList = internshipService.filterInternships(city, startingDate, endingDate,
                    major, page, size);
            return ResponseEntity.ok(new ResponseDto<>(internshipList, "List Obtained", true));
        } catch (Exception e) {
            LOGGER.error("Error getting internship list {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/institution/{id}/active")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<ResponseDto<List<ActiveInternshipDto>>> getActiveInternshipsByInstitutionId(
            @PathVariable Long id) {
        List<ActiveInternshipDto> internships = internshipService.getActiveInternshipsByInstitutionId(id);
        return ResponseEntity.ok(new ResponseDto<>(internships, null, true));
    }

    @GetMapping("/{id}/applicants")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<ResponseDto<List<ApplicantDto>>> getApplicantsByInternshipId(
            @PathVariable Long id) {
        List<ApplicantDto> applicants = internshipService.getApplicantsByInternshipId(id);
        return ResponseEntity.ok(new ResponseDto<>(applicants, null, true));
    }

    @PutMapping("/{id}/applications/{applicationId}/status/{state}")
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<ResponseDto<Boolean>> updateApplicationStatus(
            @PathVariable Long id,
            @PathVariable Long applicationId,
            @PathVariable Integer state,
            @RequestBody String message) {
        internshipApplicationService.updateApplicationStatus(id, applicationId, state, message);
        return ResponseEntity.ok(new ResponseDto<>(true, null, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<InternshipDto>> getInternshipById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDto<>(internshipService.getInternshipById(id), null, true));
    }

    @PutMapping
    @PreAuthorize("hasRole('INSTITUTION')")
    public ResponseEntity<ResponseDto<Void>> updateInternship(@RequestBody InternshipDto internshipDto) {
        LOGGER.info("Updating internship {}", internshipDto);
        internshipService.updateInternship(internshipDto);
        return ResponseEntity.ok(new ResponseDto<>(null, "Convocatoria actualizada exitosamente.", true));
    }

    @GetMapping("/{id}/details")
    @PreAuthorize("hasRole('STUDENT') or hasRole('GRADUATE')")
    public ResponseEntity<ResponseDto<InternshipDetailsDto>> getInternshipDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseDto<>(internshipService.getInternshipDetailsById(id), null, true));
    }

    @GetMapping("/pending")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseDto<List<InternshipApiDto>>> getInternshipAll() {
        return ResponseEntity.ok(new ResponseDto<>(internshipService.getInternshipAll(), null, true));
    }

    @PutMapping("/{id}/status/{state}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseDto<Long>> internshipAccepted(@PathVariable Long id, @PathVariable Integer state) {
        internshipService.internShipChangeAprovedState(id, state);
        return ResponseEntity
                .ok(new ResponseDto<>(internshipService.getInternshipApiById(id).getInternshipId(), null, true));
    }

    @PostMapping("/{id}")
    public ResponseEntity<InternshipApplicationDto> applyToInternship(
            @RequestBody InternshipApplicationDto internshipApplicationDto) {
        internshipApplicationService.applyToInternship(internshipApplicationDto);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto<List<InternshipListDto>>> getInternshipByInstitutionId(
            @RequestParam String title) {
        return ResponseEntity
                .ok(new ResponseDto<>(internshipService.getInternshipByTitleOrInstitutionName(title), null, true));
    }

    @GetMapping("/last")
    public ResponseEntity<ResponseDto<List<InternshipListDto>>> getLast5Internships() {
        return ResponseEntity.ok(new ResponseDto<>(internshipService.getTop5Internships(), null, true));
    }

    @GetMapping("/institution/{idInstitution}/status/{state}")
    public ResponseEntity<ResponseDto<List<InternshipApiDto>>> getInternshipActiveConvocatory(
            @PathVariable Long idInstitution, @PathVariable Integer state) {
        return ResponseEntity.ok(new ResponseDto<>(internshipService.getInternshipActive(idInstitution, state),
                "List of institutions and Approved states", true));
    }
}
