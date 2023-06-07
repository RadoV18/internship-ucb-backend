package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.InternshipRequirementDto;
import ucb.internship.backend.models.InternshipRequirement;

public class InternshipRequirementMapper {
    public static InternshipRequirementDto entityToDto(InternshipRequirement internshipRequirement) {
        InternshipRequirementDto internshipRequirementDto = new InternshipRequirementDto();
        internshipRequirementDto.setId(internshipRequirement.getRequirementId());
        internshipRequirementDto.setDescription(internshipRequirement.getDescription());
        return internshipRequirementDto;
    }
}
