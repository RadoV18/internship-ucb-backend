package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.models.Person;
import ucb.internship.backend.models.User;
import ucb.internship.backend.dtos.PersonDto;
import ucb.internship.backend.mapper.PersonMapper;
import ucb.internship.backend.repositories.PersonRepository;
import ucb.internship.backend.repositories.UserRepository;
import ucb.internship.backend.services.PersonsService;

@Service
public class PersonsServiceImpl implements PersonsService{

    private Logger LOGGER = LoggerFactory.getLogger(PersonsServiceImpl.class);
    private PersonRepository personRepository;
    private UserRepository userRepository;

    
    @Autowired
    public PersonsServiceImpl(PersonRepository personRepository, UserRepository userRepository) {
        this.personRepository = personRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PersonDto> getPersons() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de instituciones");
        List<Person> result = this.personRepository.findAll();
        List<PersonDto> resultDTO = new ArrayList<>();
        result.stream().forEach(person ->{
            User usuario = this.userRepository.findById(person.getUserUcb().getUserId()).orElseThrow();
            PersonDto personsDTO = PersonMapper.entitytoDto(person, usuario);
            resultDTO.add(personsDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }
    
    
}