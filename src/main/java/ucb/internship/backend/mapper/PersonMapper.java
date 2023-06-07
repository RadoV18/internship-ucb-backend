package ucb.internship.backend.mapper;

import ucb.internship.backend.models.Person;
import ucb.internship.backend.models.User;
import ucb.internship.backend.dtos.PersonDto;

public class PersonMapper {

    public static PersonDto entitytoDto(Person person, User user) {
        PersonDto personsDto = new PersonDto();
        personsDto.setPersonId(person.getPersonId());
        personsDto.setFirstName(person.getFirstName());
        personsDto.setLastName(person.getLastName());
        personsDto.setCi(person.getCi());
        personsDto.setPhoneNumber(person.getPhoneNumber());
        personsDto.setUser(UserMapper.entityToDto(user));
        return personsDto;
    }
    
}
