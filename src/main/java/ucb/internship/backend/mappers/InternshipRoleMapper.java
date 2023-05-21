package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.InternshipRoleDto;
import ucb.internship.backend.models.InternshipRole;

public class InternshipRoleMapper {

    public static InternshipRoleDto entityToDto(InternshipRole internshipRole) {
        InternshipRoleDto internshipRoleDto = new InternshipRoleDto();
        internshipRoleDto.setId(internshipRole.getInternshipRoleId());
        internshipRoleDto.setDescription(internshipRole.getDescription());
        return internshipRoleDto;
    }
}
