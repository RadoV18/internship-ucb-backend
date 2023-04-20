package ucb.internship.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.internship.backend.dtos.MajorDTO;
import ucb.internship.backend.models.Major;
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
    public ResponseEntity<List<MajorDTO>> findAllMajors() {
        try{
            return new ResponseEntity<List<MajorDTO>>(majorService.findAllMajors(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
