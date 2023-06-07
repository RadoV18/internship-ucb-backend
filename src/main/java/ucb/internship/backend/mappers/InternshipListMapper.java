package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.InternshipListDto;
import ucb.internship.backend.mapper.InstitutionsMapper;
import ucb.internship.backend.models.Internship;

public class InternshipListMapper {
    public static InternshipListDto objectToDto(Internship internship){
        InternshipListDto internshipList = new InternshipListDto();
        internshipList.setInternshipId(internship.getInternshipId());
        internshipList.setTitle(internship.getTitle());
        internshipList.setDescription(internship.getDescription());
        internshipList.setStartingDate(internship.getStartingDate());
        internshipList.setEndingDate(internship.getEndingDate());
        internshipList.setInstitution(internship.getInstitution().getName());
        internshipList.setCity(internship.getCity().getName());
        internshipList.setUrl(internship.getInstitution().getUserUcb().getS3ProfilePicture().getUrl());
        return internshipList;
    }
}
