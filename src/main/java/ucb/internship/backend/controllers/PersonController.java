package ucb.internship.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.PersonDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.models.Person;
import ucb.internship.backend.services.PersonService;

@RestController
public class PersonController {
    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PutMapping("/person")
    public ResponseEntity<ResponseDto<String>> updatePerson(@RequestParam(value = "data")String data,
                                                            @RequestParam(required = false, value = "cvFile") MultipartFile cv ) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            PersonDto personDto = objectMapper.readValue(data, PersonDto.class);
            String response = personService.updatePerson(personDto, cv);
            return new ResponseEntity<>(new ResponseDto<String>(response,"",true),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person")
    public ResponseEntity<ResponseDto<Person>> getPersonByEmail(@RequestParam String email) {
        try{
            Person person = personService.getPersonByEmail(email);
            return new ResponseEntity<>(new ResponseDto<Person>(person,"",true),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
