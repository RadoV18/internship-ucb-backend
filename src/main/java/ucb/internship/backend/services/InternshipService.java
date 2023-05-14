package ucb.internship.backend.services;

import ucb.internship.backend.dtos.InternshipApiDto;
import ucb.internship.backend.dtos.InternshipDTO;
import java.util.List;



public interface InternshipService {
    
    String createInternship(InternshipDTO internshipDto);

    InternshipApiDto getInternshipApiById(Integer id);

    List<InternshipApiDto> getInternshipAll();

    void internShipChangeAprovedState(Integer id, Integer state);
}
