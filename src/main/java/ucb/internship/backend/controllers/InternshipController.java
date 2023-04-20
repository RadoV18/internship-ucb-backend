package ucb.internship.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.services.impl.InternshipServiceImpl;
import ucb.internship.backend.dtos.InternshipDTO;
import ucb.internship.backend.models.Internship;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class InternshipController {
    private InternshipServiceImpl internshipService;
    public static final Logger LOGGER = LoggerFactory.getLogger(InternshipController.class);
    @Autowired
    public InternshipController(InternshipServiceImpl internshipService) {
        this.internshipService = internshipService;
    }
    @PostMapping("/internship")
    public ResponseEntity<String> createInternship(@RequestBody InternshipDTO internshipDto){
        LOGGER.info("Creating internship {}", internshipDto);
        String response = internshipService.createInternship(internshipDto);
        if(response.equals("Error creating internship")){
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/internship/{id}")
    public List<Internship> getInternship(@PathVariable Integer id){
        return internshipService.getInternshipById(id);
    }

}
