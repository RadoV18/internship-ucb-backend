package ucb.internship.backend.controllers;

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

import ucb.internship.backend.dtos.PersonsDto;
import ucb.internship.backend.services.PersonsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("admin/persons")
public class PersonsController {

    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsController.class);
    private PersonsService personsBL;

    @Autowired
    public PersonsController(PersonsService personsBL) {
        this.personsBL = personsBL;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PersonsDto>> get_institutions() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de instituciones");
        List<PersonsDto> result = personsBL.getPersons();
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    
}
