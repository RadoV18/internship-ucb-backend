package ucb.internship.backend.mapper;

import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Persons;
import ucb.internship.backend.dtos.GraduateDTO;

public class GraduateMapper {
    
    public static GraduateDTO entityToDto(Graduate graduateENTITY, Persons personsENTITY) {
        GraduateDTO graduateDTO = new GraduateDTO();
        graduateDTO.setGraduateId(graduateENTITY.getGraduateId());
        graduateDTO.setCampusMajorId(graduateENTITY.getCampusMajorId());
        graduateDTO.setGraduationDate(graduateENTITY.getGraduationDate());
        graduateDTO.setStatus(graduateENTITY.getStatus()); 
        graduateDTO.setPerson(personsENTITY);
        return graduateDTO;
    }
}