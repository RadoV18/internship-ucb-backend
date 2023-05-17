package ucb.internship.backend.services;
import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.models.Internship;

import java.sql.Date;
import java.util.List;

import ucb.internship.backend.dtos.*;
import org.springframework.data.domain.Page;

public interface InternshipService {
    String createInternship(InternshipDto internshipDTO);

    InternshipApiDto getInternshipApiById(Integer id);

    List<InternshipApiDto> getInternshipAll();

    void internShipChangeAprovedState(Integer id, Integer state);

    List<Internship> getInternshipById(Integer id);

    List<ActiveInternshipDto> getActiveInternshipsByInstitutionId(Long id);

    List<ApplicantDto> getApplicantsByInternshipId(Long id);

    Page<InternshipListDto> filterInternships(String city , Date startingDate, Date endingDate, String major, Integer page, Integer size);
}
