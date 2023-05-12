package ucb.internship.backend.services;

import ucb.internship.backend.dtos.InternshipApiDto;
import ucb.internship.backend.dtos.InternshipDTO;
import java.util.List;



public interface InternshipService {
    
    public String createInternship(InternshipDTO internshipDto);

    public InternshipApiDto getInternshipApiById(Integer id);

    public List<InternshipApiDto> getInternshipAll();
}
