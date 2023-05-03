package ucb.internship.backend.services;

import org.springframework.data.domain.Page;
import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.dtos.InternshipListDto;

import java.sql.Timestamp;
import java.util.Collection;

public interface InternshipService {

    String createInternship(InternshipDto internshipDto);
     public Page<InternshipListDto> filterInternships(String city , Timestamp startingDate, Timestamp endingDate, Collection<Integer> majors, Integer page, Integer size);

}
