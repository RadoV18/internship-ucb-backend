package ucb.internship.backend.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.PersonDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.Person;


public interface PersonService {
    String updatePerson(PersonDto personDto, MultipartFile cv) throws FileStorageException;
    Person getPersonByEmail(String email);
}
