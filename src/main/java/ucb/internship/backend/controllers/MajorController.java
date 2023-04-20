package ucb.internship.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.internship.backend.dtos.MajorDto;
import ucb.internship.backend.services.impl.MajorServiceImpl;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MajorController {
    private MajorServiceImpl majorService;
    @Autowired
    public MajorController(MajorServiceImpl majorService) {
        this.majorService = majorService;
    }
    @GetMapping("/major")
    public ResponseEntity<List<MajorDto>> findAllMajors() {
        try{
            return new ResponseEntity<List<MajorDto>>(majorService.findAllMajors(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
