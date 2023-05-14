package ucb.internship.backend.services;

import java.util.List;
import ucb.internship.backend.dtos.GraduateDTO;


public interface GraduateService {
    
    List<GraduateDTO> getGraduates();

    GraduateDTO getGraduateById(Integer id);

}
