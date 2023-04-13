package ucb.internship.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.internship.backend.dtos.MajorDTO;
import ucb.internship.backend.models.Major;
import ucb.internship.backend.services.impl.MajorServiceImpl;
import java.util.List;

@RestController
public class MajorController {
    private MajorServiceImpl majorService;
    @Autowired
    public MajorController(MajorServiceImpl majorService) {
        this.majorService = majorService;
    }
    @GetMapping("/majors")
    public List<MajorDTO> findAllMajors() {
        return majorService.findAllMajors();
    }
}
