package ucb.internship.backend.services;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.models.Persons;
import ucb.internship.backend.models.User;
import ucb.internship.backend.dtos.PersonsDTO;
import ucb.internship.backend.mapper.PersonsMAPPER;
import ucb.internship.backend.repositories.PersonsRepository;
import ucb.internship.backend.repositories.UserRepository;

@Service
public class PersonsService {

    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsService.class);
    private PersonsRepository personsREPOSITORY;
    private UserRepository userREPOSITORY;

    
    @Autowired
    public PersonsService(PersonsRepository personsREPOSITORY, UserRepository userREPOSITORY) {
        this.personsREPOSITORY = personsREPOSITORY;
        this.userREPOSITORY = userREPOSITORY;
    }


    public List<PersonsDTO> getPersons() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de instituciones");
        List<Persons> result = this.personsREPOSITORY.findAll();
        List<PersonsDTO> resultDTO = new ArrayList<>();
        result.stream().forEach(person ->{
            User usuario = this.userREPOSITORY.findById(person.getUserUcb().getUserId()).orElseThrow();
            PersonsDTO personsDTO = PersonsMAPPER.entitytoDto(person, usuario);
            resultDTO.add(personsDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }
    
    
}
