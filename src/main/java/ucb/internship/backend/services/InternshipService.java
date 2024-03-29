package ucb.internship.backend.services;
import jakarta.persistence.criteria.CriteriaBuilder;
import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.models.Internship;

import java.sql.Date;
import java.util.List;

import ucb.internship.backend.dtos.*;
import org.springframework.data.domain.Page;

public interface InternshipService {
    String createInternship(InternshipDto internshipDTO);

    InternshipApiDto getInternshipApiById(Long id);

    List<InternshipApiDto> getInternshipAll();

    void internShipChangeAprovedState(Long id, Integer state);

    InternshipDto getInternshipById(Long id);

    List<ActiveInternshipDto> getActiveInternshipsByInstitutionId(Long id);

    List<ApplicantDto> getApplicantsByInternshipId(Long id);

    Page<InternshipListDto> filterInternships(String city , Date startingDate, Date endingDate, String major, Integer page, Integer size);

    InternshipDetailsDto getInternshipDetailsById(Long id);
  
    List<InternshipListDto> getInternshipByTitleOrInstitutionName(String title);
  
    List<InternshipListDto> getTop5Internships();

    void updateInternship(InternshipDto internshipDto);

    List<InternshipApiDto> getInternshipActive(Long idInstitution, Integer state);
}
