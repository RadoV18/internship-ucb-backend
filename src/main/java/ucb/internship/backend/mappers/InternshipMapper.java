package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.models.Internship;
import ucb.internship.backend.models.InternshipMajor;

import java.util.stream.Collectors;

public class InternshipMapper {
    public static InternshipDto entityToDto(Internship internship) {
        InternshipDto internshipDto = new InternshipDto();
        internshipDto.setInternshipId(internship.getInternshipId());
        internshipDto.setInternshipBenefits(internship.getInternshipBenefits());
        internshipDto.setInternshipRequirements(internship.getInternshipRequirements());
        internshipDto.setInternshipRoles(internship.getInternshipRoles());
        internshipDto.setIsApproved(internship.getIsApproved());
        internshipDto.setStartingDate(internship.getStartingDate());
        internshipDto.setEndingDate(internship.getEndingDate());
        internshipDto.setCityId(internship.getCityId());
        internshipDto.setMajorList(internship.getMajorList().stream().map(InternshipMajor::getMajor).collect(Collectors.toList()));
        return internshipDto;
    }
}
