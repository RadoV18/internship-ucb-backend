package ucb.internship.backend.mapper;

import ucb.internship.backend.dtos.InstitutionResDto;
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

    public static InstitutionResDto entityToResDto(Institution institution) {
        InstitutionResDto institutionResDto = new InstitutionResDto();
        institutionResDto.setInstitutionId(institution.getInstitutionId());
        institutionResDto.setName(institution.getName());
        institutionResDto.setDescription(institution.getDescription());
        institutionResDto.setArea(institution.getArea());
        institutionResDto.setContactFirstName(institution.getContactFirstName());
        institutionResDto.setContactLastName(institution.getContactLastName());
        institutionResDto.setContactEmail(institution.getContactEmail());
        institutionResDto.setContactPhone(institution.getContactPhone());
        institutionResDto.setContactPosition(institution.getContactPosition());
        institutionResDto.setUser(UserMapper.entityToResDto(institution.getUserUcb()));
        return institutionResDto;
    }
}