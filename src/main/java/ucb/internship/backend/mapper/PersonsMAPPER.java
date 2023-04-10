package ucb.internship.backend.mapper;

import ucb.internship.backend.models.PersonsENTITY;
import ucb.internship.backend.models.UserENTITY;
import ucb.internship.backend.dtos.PersonsDTO;

public class PersonsMAPPER {

    public static PersonsDTO entitytoDto(PersonsENTITY personsENTITY, UserENTITY userENTITY) {
        PersonsDTO personsDTO = new PersonsDTO();
        personsDTO.setPersonId(personsENTITY.getPerson_id());
        personsDTO.setFirstName(personsENTITY.getFirst_name());
        personsDTO.setLastName(personsENTITY.getLast_name());
        personsDTO.setCi(personsENTITY.getCi());
        personsDTO.setPhoneNumber(personsENTITY.getPhone_number());
        personsDTO.setUser(userENTITY);
        return personsDTO;

        
    }
    
}
