package ucb.internship.backend.services;

import java.util.List;
import ucb.internship.backend.dtos.InstitucionsDTO;


public interface InstitutionsService {
    
    List<InstitucionsDTO> getInstitutions();

    void requestApproved(Long id);
}
