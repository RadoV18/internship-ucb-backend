package ucb.internship.backend.mapper;

import ucb.internship.backend.models.Persons;
import ucb.internship.backend.models.User;
import ucb.internship.backend.dtos.PersonsDto;

public class PersonsMapper {

    public static PersonsDto entitytoDto(Persons personsENTITY, User user) {
        PersonsDto personsDTO = new PersonsDto();
        personsDTO.setPersonId(personsENTITY.getPersonId());
        personsDTO.setFirstName(personsENTITY.getFirstName());
        personsDTO.setLastName(personsENTITY.getLastName());
        personsDTO.setCi(personsENTITY.getCi());
        personsDTO.setPhoneNumber(personsENTITY.getPhoneNumber());
        personsDTO.setUser(user);
        return personsDTO;
    }
    
}
