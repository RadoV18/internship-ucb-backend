package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.PersonDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.Person;
import ucb.internship.backend.models.S3Object;
import ucb.internship.backend.repositories.PersonRepository;
import ucb.internship.backend.services.FileStorageService;
import ucb.internship.backend.services.PersonService;
@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private FileStorageService fileStorageService;
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, FileStorageService fileStorageService) {
        this.personRepository = personRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public String updatePerson(PersonDto personDto, MultipartFile cv) throws FileStorageException {
        Person person = personRepository.findById(personDto.getPersonId()).orElseThrow();
        S3Object s3Object = fileStorageService.createObject(cv);
        person.setS3Cv(s3Object.getS3ObjectId());
        person.setPhoneNumber(personDto.getPhoneNumber());
        personRepository.save(person);
        return "Updated";
    }
}
