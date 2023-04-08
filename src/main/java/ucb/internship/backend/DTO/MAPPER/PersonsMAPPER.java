package ucb.internship.backend.DTO.MAPPER;

import ucb.internship.backend.DAO.ENTITY.PersonsENTITY;
import ucb.internship.backend.DTO.PersonsDTO;

public class PersonsMAPPER {

    public static PersonsDTO entitytoDto(PersonsENTITY personsENTITY) {
        PersonsDTO personsDTO = new PersonsDTO();
        personsDTO.setPerson_id(personsENTITY.getPerson_id());
        personsDTO.setFirst_name(personsENTITY.getFirst_name());
        personsDTO.setLast_name(personsENTITY.getLast_name());
        personsDTO.setCi(personsENTITY.getCi());
        personsDTO.setPhone_number(personsENTITY.getPhone_number());
        return personsDTO;

        
    }
    
}
