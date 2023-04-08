package ucb.internship.backend.API;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.BL.PersonsBL;
import ucb.internship.backend.DTO.PersonsDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("obtener/personas")
public class PersonsAPI {

    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsAPI.class);
    private PersonsBL personsBL;

    @Autowired
    public PersonsAPI(PersonsBL personsBL) {
        this.personsBL = personsBL;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PersonsDTO>> get_institutions() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de instituciones");
        List<PersonsDTO> result = personsBL.getPersons();
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    
}
