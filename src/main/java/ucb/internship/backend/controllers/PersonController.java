package ucb.internship.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.PersonDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.services.PersonService;

@RestController
public class PersonController {
    private PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PutMapping("/person")
    public ResponseEntity<ResponseDto<String>> updatePerson(@RequestBody PersonDto personDto, @RequestParam MultipartFile cv) throws Exception {
        try{
            String response = personService.updatePerson(personDto, cv);
            return new ResponseEntity<>(new ResponseDto<String>(response,"",true),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
