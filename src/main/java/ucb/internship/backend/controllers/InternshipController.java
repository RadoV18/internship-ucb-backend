package ucb.internship.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.InternshipListDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.services.impl.InternshipServiceImpl;
import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.models.Internship;

import java.sql.Timestamp;
import java.util.Collection;
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
    public ResponseEntity<String> createInternship(@RequestBody InternshipDto internshipDto){
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
    @GetMapping("/internship")
    public ResponseEntity<ResponseDto<Page<InternshipListDto>>> getInternship(
            @RequestParam(required = false) String city,
            @RequestParam(required = true) Collection<Integer> major,
            @RequestParam(required = false) Timestamp startingDate,
            @RequestParam(required = false) Timestamp endingDate,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size){
       try{
           LOGGER.info("starting get internship list with parameters city: {}, major: {}, startingDate: {}, endingDate: {}, page: {}, size: {}", city, major, startingDate, endingDate, page, size);
           Page<InternshipListDto> internshipList = internshipService.filterInternships(city, startingDate, endingDate, major, page, size);
           return ResponseEntity.ok(new ResponseDto<>( internshipList,"List Obtained",true));
       } catch (Exception e){
           LOGGER.error("Error getting internship list {}", e.getMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }

    }


}
