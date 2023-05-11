package ucb.internship.backend.services;

import java.util.List;

import ucb.internship.backend.dtos.ActiveInternshipDto;
import ucb.internship.backend.dtos.ApplicantDto;
import ucb.internship.backend.dtos.InternshipDTO;
import ucb.internship.backend.models.Internship;

public interface InternshipService {
    String createInternship(InternshipDTO internshipDTO);

    List<Internship> getInternshipById(Integer id);

    List<ActiveInternshipDto> getActiveInternshipsByInstitutionId(Integer id);

    List<ApplicantDto> getApplicantsByInternshipId(Integer id);

}
