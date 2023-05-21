package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.InternshipBenefitDto;
import ucb.internship.backend.models.InternshipBenefit;

public class InternshipBenefitMapper {
    public static InternshipBenefitDto entityToDto(InternshipBenefit internshipBenefit) {
        InternshipBenefitDto internshipBenefitDto = new InternshipBenefitDto();
        internshipBenefitDto.setId(internshipBenefit.getInternshipBenefitId());
        internshipBenefitDto.setDescription(internshipBenefit.getDescription());
        return internshipBenefitDto;
    }
}
