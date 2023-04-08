package ucb.internship.backend.BL;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.DAO.ENTITY.PersonsENTITY;
import ucb.internship.backend.DAO.REPOSITORY.PersonsREPOSITORY;
import ucb.internship.backend.DTO.PersonsDTO;
import ucb.internship.backend.DTO.MAPPER.PersonsMAPPER;

@Service
public class PersonsBL {

    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsBL.class);
    private PersonsREPOSITORY personsREPOSITORY;

    @Autowired
    public PersonsBL(PersonsREPOSITORY personsREPOSITORY) {
        this.personsREPOSITORY = personsREPOSITORY;
    }

    
    public List<PersonsDTO> getPersons() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de instituciones");
        List<PersonsENTITY> result = this.personsREPOSITORY.findAll();
        List<PersonsDTO> resultDTO = new ArrayList<>();
        result.stream().forEach(person ->{
            PersonsDTO personsDTO = PersonsMAPPER.entitytoDto(person);
            resultDTO.add(personsDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }
    
    
}
