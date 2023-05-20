package ucb.internship.backend.mapper;

import ucb.internship.backend.dtos.InstitucionsDto;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.User;

public class InstitutionsMapper {

    public static InstitucionsDto entityToDto(Institution institution, User user) {
        InstitucionsDto institucionsDTO = new InstitucionsDto();
        institucionsDTO.setInstitutionId(institution.getInstitutionId());
        institucionsDTO.setName(institution.getName());
        institucionsDTO.setDescription(institution.getDescription());
        institucionsDTO.setArea(institution.getArea());
        institucionsDTO.setContactFirstName(institution.getContactFirstName());
        institucionsDTO.setContactLastName(institution.getContactLastName());
        institucionsDTO.setContactEmail(institution.getContactEmail());
        institucionsDTO.setContactPhone(institution.getContactPhone());
        institucionsDTO.setUserUcb(user);
        return institucionsDTO;
    }
    
}