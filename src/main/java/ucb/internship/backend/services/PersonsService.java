package ucb.internship.backend.services;

import java.util.List;

import ucb.internship.backend.dtos.PersonsDto;


public interface PersonsService {

    List<PersonsDto> getPersons();
    
}
