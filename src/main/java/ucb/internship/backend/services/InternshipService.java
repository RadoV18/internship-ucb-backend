package ucb.internship.backend.services;

import java.util.List;

import ucb.internship.backend.dtos.ActiveInternshipDto;
import ucb.internship.backend.dtos.ApplicantDto;
import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.models.Internship;
import java.sql.Timestamp;
import java.util.Collection;
import org.springframework.data.domain.Page;
import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.dtos.InternshipListDto;

public interface InternshipService {
    String createInternship(InternshipDto internshipDTO);

    List<Internship> getInternshipById(Integer id);

    List<ActiveInternshipDto> getActiveInternshipsByInstitutionId(Integer id);

    List<ApplicantDto> getApplicantsByInternshipId(Integer id);

    Page<InternshipListDto> filterInternships(String city , Timestamp startingDate, Timestamp endingDate, String major, Integer page, Integer size);
}
