package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.InternshipListDto;

public class InternshipListMapper {
    public static InternshipListDto objectToDto(Object[] object){
        InternshipListDto internshipList = new InternshipListDto();
        internshipList.setInternshipId((Integer) object[0]);
        internshipList.setTitle((String) object[1]);
        internshipList.setDescription((String) object[2]);
        internshipList.setStartingDate((java.sql.Timestamp) object[3]);
        internshipList.setEndingDate((java.sql.Timestamp) object[4]);
        internshipList.setInstitution((String) object[6]);
        internshipList.setUrl((String) object[7]);
        internshipList.setCity((String) object[5]);
        return internshipList;
    }
}
