package ucb.internship.backend.mapper;

import ucb.internship.backend.dtos.InstitutionsDto;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.User;

public class InstitutionsMapper {

    public static InstitutionsDto entityToDto(Institution institution, User user) {
        InstitutionsDto institutionsDto = new InstitutionsDto();
        institutionsDto.setInstitutionId(institution.getInstitutionId());
        institutionsDto.setName(institution.getName());
        institutionsDto.setDescription(institution.getDescription());
        institutionsDto.setArea(institution.getArea());
        institutionsDto.setContactFirstName(institution.getContactFirstName());
        institutionsDto.setContactLastName(institution.getContactLastName());
        institutionsDto.setContactEmail(institution.getContactEmail());
        institutionsDto.setContactPhone(institution.getContactPhone());
        institutionsDto.setContactPosition(institution.getContactPosition());
        institutionsDto.setUser(UserMapper.entityToDto(user));
        return institutionsDto;
    }
    
}