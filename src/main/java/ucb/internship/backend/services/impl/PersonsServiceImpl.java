package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.models.Persons;
import ucb.internship.backend.models.User;
import ucb.internship.backend.dtos.PersonsDto;
import ucb.internship.backend.mapper.PersonsMapper;
import ucb.internship.backend.repositories.PersonsRepository;
import ucb.internship.backend.repositories.UserRepository;
import ucb.internship.backend.services.PersonsService;

@Service
public class PersonsServiceImpl implements PersonsService{

    private Logger LOGGER = LoggerFactory.getLogger(PersonsServiceImpl.class);
    private PersonsRepository personsREPOSITORY;
    private UserRepository userREPOSITORY;

    
    @Autowired
    public PersonsServiceImpl(PersonsRepository personsREPOSITORY, UserRepository userREPOSITORY) {
        this.personsREPOSITORY = personsREPOSITORY;
        this.userREPOSITORY = userREPOSITORY;
    }

    @Override
    public List<PersonsDto> getPersons() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de instituciones");
        List<Persons> result = this.personsREPOSITORY.findAll();
        List<PersonsDto> resultDTO = new ArrayList<>();
        result.stream().forEach(person ->{
            User usuario = this.userREPOSITORY.findById(person.getUserUcb().getUserId()).orElseThrow();
            PersonsDto personsDTO = PersonsMapper.entitytoDto(person, usuario);
            resultDTO.add(personsDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }
    
    
}