package ucb.internship.backend.mapper;

import ucb.internship.backend.models.InstitutionsENTITY;
import ucb.internship.backend.models.UserENTITY;
import ucb.internship.backend.dtos.InstitucionsDTO;
import ucb.internship.backend.dtos.UserDTO;

public class InstitutionsMAPPER {

    public static InstitucionsDTO entityToDto(InstitutionsENTITY institution, UserENTITY user) {
        InstitucionsDTO institucionsDTO = new InstitucionsDTO();
        institucionsDTO.setInstitutionId(institution.getInstitution_id());
        institucionsDTO.setName(institution.getName());
        institucionsDTO.setDescription(institution.getDescription());
        institucionsDTO.setArea(institution.getArea());
        institucionsDTO.setContactFirstName(institution.getContact_first_name());
        institucionsDTO.setContactLastName(institution.getContact_last_name());
        institucionsDTO.setContactEmail(institution.getContact_email());
        institucionsDTO.setContactPhone(institution.getContact_phone());
        institucionsDTO.setUser(user);
        return institucionsDTO;
    }

    // public static InstitutionsENTITY dtoToEntity(InstitucionsDTO institucionsDTO) {
        
    // }
    
}
