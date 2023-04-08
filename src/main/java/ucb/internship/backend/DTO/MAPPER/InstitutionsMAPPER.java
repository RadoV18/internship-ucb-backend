package ucb.internship.backend.DTO.MAPPER;

import ucb.internship.backend.DAO.ENTITY.InstitutionsENTITY;
import ucb.internship.backend.DAO.ENTITY.UserENTITY;
import ucb.internship.backend.DTO.InstitucionsDTO;
import ucb.internship.backend.DTO.UserDTO;

public class InstitutionsMAPPER {

    public static InstitucionsDTO entityToDto(InstitutionsENTITY institution, UserENTITY user) {
        InstitucionsDTO institucionsDTO = new InstitucionsDTO();
        institucionsDTO.setInstitution_id(institution.getInstitution_id());
        institucionsDTO.setName(institution.getName());
        institucionsDTO.setDescription(institution.getDescription());
        institucionsDTO.setArea(institution.getArea());
        institucionsDTO.setContact_first_name(institution.getContact_first_name());
        institucionsDTO.setContact_last_name(institution.getContact_last_name());
        institucionsDTO.setContact_email(institution.getContact_email());
        institucionsDTO.setContact_phone(institution.getContact_phone());
        institucionsDTO.setUser_ucb_id(user);
        return institucionsDTO;
    }

    // public static InstitutionsENTITY dtoToEntity(InstitucionsDTO institucionsDTO) {
        
    // }
    
}
