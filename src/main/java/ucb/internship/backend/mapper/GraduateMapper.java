package ucb.internship.backend.mapper;

import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Persons;
import ucb.internship.backend.dtos.GraduateDto;

public class GraduateMapper {
    
    public static GraduateDto entityToDto(Graduate graduateENTITY, Persons personsENTITY) {
        GraduateDto graduateDTO = new GraduateDto();
        graduateDTO.setGraduateId(graduateENTITY.getGraduateId());
        graduateDTO.setCampusMajorId(graduateENTITY.getCampusMajorId());
        graduateDTO.setGraduationDate(graduateENTITY.getGraduationDate());
        graduateDTO.setStatus(graduateENTITY.getStatus()); 
        graduateDTO.setPerson(personsENTITY);
        return graduateDTO;
    }
}