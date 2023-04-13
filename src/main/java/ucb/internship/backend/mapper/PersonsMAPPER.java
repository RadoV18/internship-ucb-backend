package ucb.internship.backend.mapper;

import ucb.internship.backend.models.Persons;
import ucb.internship.backend.models.User;
import ucb.internship.backend.dtos.PersonsDTO;

public class PersonsMAPPER {

    public static PersonsDTO entitytoDto(Persons personsENTITY, User user) {
        PersonsDTO personsDTO = new PersonsDTO();
        personsDTO.setPersonId(personsENTITY.getPersonId());
        personsDTO.setFirstName(personsENTITY.getFirstName());
        personsDTO.setLastName(personsENTITY.getLastName());
        personsDTO.setCi(personsENTITY.getCi());
        personsDTO.setPhoneNumber(personsENTITY.getPhoneNumber());
        personsDTO.setUser(user);
        return personsDTO;

        
    }
    
}
