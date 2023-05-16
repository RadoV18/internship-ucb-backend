package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.InternshipApiDto;
import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.models.*;

import java.util.ArrayList;
import java.util.List;
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
        internshipDto.setCityId(internship.getCity().getCityId());
        internshipDto.setMajorList(internship.getMajorList().stream().map(InternshipMajor::getMajor).collect(Collectors.toList()));
        return internshipDto;
    }

    public static InternshipApiDto entityToApiDto(Internship internship) {
        InternshipApiDto internshipApiDto = new InternshipApiDto();
        internshipApiDto.setInternshipId(internship.getInternshipId());
        internshipApiDto.setInstitution(internship.getInstitution().getName());
        internshipApiDto.setCity(internship.getCity().getName());
        internshipApiDto.setTitle(internship.getTitle());
        internshipApiDto.setDescription(internship.getDescription());
        internshipApiDto.setApproved(internship.getIsApproved());
        internshipApiDto.setStartingDate(internship.getStartingDate());
        internshipApiDto.setEndingDate(internship.getEndingDate());
        List<String> benefitList = new ArrayList<>();
        List<String> roleList = new ArrayList<>();
        List<String> requirementList = new ArrayList<>();
        List<String> majorList = new ArrayList<>();
        for (InternshipBenefit benefit : internship.getInternshipBenefits()) {
            benefitList.add(benefit.getDescription());
        }
        for (InternshipRole role : internship.getInternshipRoles()) {
            roleList.add(role.getDescription());
        }
        for (InternshipRequirement requirement : internship.getInternshipRequirements()) {
            requirementList.add(requirement.getDescription());
        }
        for (InternshipMajor major : internship.getMajorList()) {
            majorList.add(major.getMajor().getName());
        }
        internshipApiDto.setMajorList(majorList);
        internshipApiDto.setInternshipRequirements(requirementList);
        internshipApiDto.setInternshipRoles(roleList);
        internshipApiDto.setInternshipBenefits(benefitList);
        return internshipApiDto;
    }
}
