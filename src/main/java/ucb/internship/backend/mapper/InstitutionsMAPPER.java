package ucb.internship.backend.mapper;

import ucb.internship.backend.models.InstitutionsENTITY;
import ucb.internship.backend.models.UserENTITY;
import ucb.internship.backend.dtos.InstitucionsDTO;

public class InstitutionsMAPPER {

    public static InstitucionsDTO entityToDto(InstitutionsENTITY institution, UserENTITY user) {
        InstitucionsDTO institucionsDTO = new InstitucionsDTO();
        institucionsDTO.setInstitutionId(institution.getInstitutionId());
        institucionsDTO.setName(institution.getName());
        institucionsDTO.setDescription(institution.getDescription());
        institucionsDTO.setArea(institution.getArea());
        institucionsDTO.setContactFirstName(institution.getContactFirstName());
        institucionsDTO.setContactLastName(institution.getContactLastName());
        institucionsDTO.setContactEmail(institution.getContactEmail());
        institucionsDTO.setContactPhone(institution.getContactPhone());
        institucionsDTO.setUser(user);
        return institucionsDTO;
    }

    // public static InstitutionsENTITY dtoToEntity(InstitucionsDTO institucionsDTO) {
        
    // }
    
}
