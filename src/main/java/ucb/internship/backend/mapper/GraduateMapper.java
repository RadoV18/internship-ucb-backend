package ucb.internship.backend.mapper;

import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Person;
import ucb.internship.backend.dtos.GraduateDto;
import ucb.internship.backend.dtos.PersonDto;

public class GraduateMapper {
    public static GraduateDto entityToDto(Graduate graduate, Person person) {
        GraduateDto graduateDto = new GraduateDto();
        graduateDto.setGraduateId(graduate.getGraduateId());
        graduateDto.setCampusMajorId(graduate.getCampusMajor().getCampusMajorId());
        graduateDto.setGraduationDate(graduate.getGraduationDate());
        graduateDto.setStatus(graduate.getStatus()); 
        PersonDto personDto = new PersonDto();
        personDto.setPersonId(person.getPersonId());
        personDto.setUser(UserMapper.entityToDto(person.getUserUcb()));
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setCi(person.getCi());
        personDto.setPhoneNumber(person.getPhoneNumber());
        graduateDto.setPersonDto(personDto);
        return graduateDto;
    }
}