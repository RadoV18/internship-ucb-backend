package ucb.internship.backend.services;

import java.util.List;
import ucb.internship.backend.dtos.InstitutionsDto;


public interface InstitutionsService {
    
    List<InstitutionsDto> getInstitutions();

    void requestApproved(Long id, Integer state);
}
