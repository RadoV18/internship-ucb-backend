package ucb.internship.backend.services;

import java.util.List;
import ucb.internship.backend.dtos.InstitucionsDto;


public interface InstitutionsService {
    
    List<InstitucionsDto> getInstitutions();

    void requestApproved(Long id, Integer state);
}
