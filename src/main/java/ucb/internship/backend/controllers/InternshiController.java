package ucb.internship.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.services.InternshipService;
import ucb.internship.backend.dtos.InternshipApiDto;
import ucb.internship.backend.dtos.InternshipDTO;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins = "*")
public class InternshiController {
    private InternshipService internshipService;
    public static final Logger LOGGER = LoggerFactory.getLogger(InternshiController.class);
    @Autowired
    public InternshiController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }
    @PostMapping("/internship")
    public String createInternship(@RequestBody InternshipDTO internshipDto){
        LOGGER.info("Creating internship {}", internshipDto);
        return internshipService.createInternship(internshipDto);
    }

    @GetMapping("/internship/{id}")
    public InternshipApiDto getInternship(@PathVariable Integer id){
        return internshipService.getInternshipApiById(id);
    }
    @GetMapping("/internship")
    public List<InternshipApiDto> getInternshipAll(){
        return internshipService.getInternshipAll();
    }

    @PutMapping("/internship/{state}/{id}")
    public void internshipAcepted(@PathVariable Integer id,@PathVariable Integer state) {
        internshipService.internShipChangeAprovedState(id, state);
    }

}
