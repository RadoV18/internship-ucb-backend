package ucb.internship.backend.mapper;

import ucb.internship.backend.models.PersonsENTITY;
import ucb.internship.backend.models.UserENTITY;
import ucb.internship.backend.dtos.PersonsDTO;

public class PersonsMAPPER {

    public static PersonsDTO entitytoDto(PersonsENTITY personsENTITY, UserENTITY userENTITY) {
        PersonsDTO personsDTO = new PersonsDTO();
        personsDTO.setPersonId(personsENTITY.getPersonId());
        personsDTO.setFirstName(personsENTITY.getFirstName());
        personsDTO.setLastName(personsENTITY.getLastName());
        personsDTO.setCi(personsENTITY.getCi());
        personsDTO.setPhoneNumber(personsENTITY.getPhoneNumber());
        personsDTO.setUser(userENTITY);
        return personsDTO;

        
    }
    
}
