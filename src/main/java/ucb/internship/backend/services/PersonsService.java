package ucb.internship.backend.services;

import java.util.ArrayList;
import java.util.List;

import ucb.internship.backend.dtos.PersonsDTO;


public interface PersonsService {

    List<PersonsDTO> getPersons();
    
}
