package ucb.internship.backend.services;

import java.util.List;
import ucb.internship.backend.dtos.GraduateDto;


public interface GraduateService {
    
    List<GraduateDto> getGraduates();

    GraduateDto getGraduateById(Long id);

}
