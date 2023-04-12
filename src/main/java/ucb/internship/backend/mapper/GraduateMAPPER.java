package ucb.internship.backend.mapper;

import ucb.internship.backend.models.GraduateENTITY;
import ucb.internship.backend.models.PersonsENTITY;
import ucb.internship.backend.dtos.GraduateDTO;

public class GraduateMAPPER {
    
    public static GraduateDTO entityToDto(GraduateENTITY graduateENTITY, PersonsENTITY personsENTITY) {
        GraduateDTO graduateDTO = new GraduateDTO();
        graduateDTO.setGraduateId(graduateENTITY.getGraduateId());
        graduateDTO.setCampusMajorId(graduateENTITY.getCampusMajorId());
        graduateDTO.setGraduationDate(graduateENTITY.getGraduationDate());
        graduateDTO.setStatus(graduateENTITY.getStatus()); 
        graduateDTO.setPerson(personsENTITY);
        return graduateDTO;
    }
}
