package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.*;
import ucb.internship.backend.mapper.InstitutionsMapper;
import ucb.internship.backend.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InternshipMapper {
    public static InternshipDto entityToDto(Internship internship) {
        InternshipDto internshipDto = new InternshipDto();
        internshipDto.setInternshipId(internship.getInternshipId());
        internshipDto.setInternshipBenefits(internship.getInternshipBenefits().stream()
                .map(InternshipBenefitMapper::entityToDto).collect(Collectors.toList()));
        internshipDto.setInternshipRequirements(internship.getInternshipRequirements().stream()
                .map(InternshipRequirementMapper::entityToDto).collect(Collectors.toList()));
        internshipDto.setInternshipRoles(internship.getInternshipRoles().stream().map(InternshipRoleMapper::entityToDto)
                .collect(Collectors.toList()));
        internshipDto.setIsApproved(internship.getIsApproved());
        internshipDto.setStartingDate(internship.getStartingDate());
        internshipDto.setEndingDate(internship.getEndingDate());
        internshipDto.setCityId(internship.getCity().getCityId());
        internshipDto.setMajorList(internship.getMajorList().stream()
                .map(internshipMajor -> MajorMapper.entityToDto(internshipMajor.getMajor()))
                .toList());
        internshipDto.setInternshipQuestions(internship.getInternshipQuestions().stream()
                .map(InternshipQuestionMapper::entityToDto).collect(Collectors.toList()));
        internshipDto.setTitle(internship.getTitle());
        internshipDto.setDescription(internship.getDescription());
        internshipDto.setInstitutionId(internship.getInstitution().getInstitutionId());
        return internshipDto;
    }

    public static InternshipApiDto entityToApiDto(Internship internship) {
        InternshipApiDto internshipApiDto = new InternshipApiDto();
        internshipApiDto.setInternshipId(internship.getInternshipId());
        internshipApiDto.setInstitution(internship.getInstitution().getName());
        internshipApiDto.setProfilePicture(internship.getInstitution().getUserUcb().getS3ProfilePicture().getUrl());
        internshipApiDto.setCity(internship.getCity().getName());
        internshipApiDto.setTitle(internship.getTitle());
        internshipApiDto.setDescription(internship.getDescription());
        internshipApiDto.setIsApproved(internship.getIsApproved());
        internshipApiDto.setStartingDate(internship.getStartingDate());
        internshipApiDto.setEndingDate(internship.getEndingDate());
        List<String> benefitList = new ArrayList<>();
        for (InternshipBenefit benefit : internship.getInternshipBenefits()) {
            benefitList.add(benefit.getDescription());
        }
        internshipApiDto.setInternshipBenefits(benefitList);
        List<String> roleList = new ArrayList<>();
        for (InternshipRole role : internship.getInternshipRoles()) {
            roleList.add(role.getDescription());
        }
        internshipApiDto.setInternshipRoles(roleList);
        List<String> requirementList = new ArrayList<>();
        for (InternshipRequirement requirement : internship.getInternshipRequirements()) {
            requirementList.add(requirement.getDescription());
        }
        internshipApiDto.setInternshipRequirements(requirementList);
        List<String> majorList = new ArrayList<>();
        for (InternshipMajor major : internship.getMajorList()) {
            majorList.add(major.getMajor().getName());
        }
        internshipApiDto.setMajorList(majorList);
        List<String> questionList = new ArrayList<>();
        for (InternshipQuestion question : internship.getInternshipQuestions()) {
            questionList.add(question.getDescription());
        }
        internshipApiDto.setInternshipQuestions(questionList);
        return internshipApiDto;
    }

    public static InternshipDetailsDto entityToDetailsDto(Internship internship) {
        InternshipDetailsDto internshipDetailsDto = new InternshipDetailsDto();
        internshipDetailsDto.setInternshipId(internship.getInternshipId());
        internshipDetailsDto.setTitle(internship.getTitle());
        internshipDetailsDto.setDescription(internship.getDescription());
        internshipDetailsDto.setStartingDate(internship.getStartingDate());
        internshipDetailsDto.setEndingDate(internship.getEndingDate());
        internshipDetailsDto.setInstitution(InstitutionsMapper.entityToResDto(internship.getInstitution()));
        internshipDetailsDto.setCity(CityMapper.entityToDto(internship.getCity()));
        List<InternshipBenefitDto> benefitList = new ArrayList<>();
        for (InternshipBenefit benefit : internship.getInternshipBenefits()) {
            benefitList.add(InternshipBenefitMapper.entityToDto(benefit));
        }
        internshipDetailsDto.setInternshipBenefits(benefitList);
        List<InternshipRequirementDto> requirementList = new ArrayList<>();
        for (InternshipRequirement requirement : internship.getInternshipRequirements()) {
            requirementList.add(InternshipRequirementMapper.entityToDto(requirement));
        }
        internshipDetailsDto.setInternshipRequirements(requirementList);
        List<InternshipRoleDto> roleList = new ArrayList<>();
        for (InternshipRole role : internship.getInternshipRoles()) {
            roleList.add(InternshipRoleMapper.entityToDto(role));
        }
        internshipDetailsDto.setInternshipRoles(roleList);
        List<MajorDto> majorList = new ArrayList<>();
        for (InternshipMajor major : internship.getMajorList()) {
            majorList.add(MajorMapper.entityToDto(major.getMajor()));
        }
        internshipDetailsDto.setMajorList(majorList);
        List<InternshipQuestionDto> questionList = new ArrayList<>();
        for (InternshipQuestion question : internship.getInternshipQuestions()) {
            questionList.add(InternshipQuestionMapper.entityToDto(question));
        }
        internshipDetailsDto.setInternshipQuestions(questionList);
        return internshipDetailsDto;
    }
}
