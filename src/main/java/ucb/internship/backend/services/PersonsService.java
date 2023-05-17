package ucb.internship.backend.services;

import java.util.List;

import ucb.internship.backend.dtos.PersonDto;


public interface PersonsService {

    List<PersonDto> getPersons();
    
}
