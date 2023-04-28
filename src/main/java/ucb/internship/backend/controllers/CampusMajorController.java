package ucb.internship.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.dtos.CampusMajorDto;
import ucb.internship.backend.models.CampusMajor;
import ucb.internship.backend.repositories.CampusMajorRepository;

@RestController
@RequestMapping("/api/campusmajor")
public class CampusMajorController {
    @Autowired
    private CampusMajorRepository campusMajorRepository;

    @GetMapping
    public ResponseEntity<List<CampusMajorDto>> getCampusMajor() {
        List<CampusMajor> campusMajors = this.campusMajorRepository.findAll();
        List<CampusMajorDto> campusMajorDtos = new ArrayList<>();
        for (CampusMajor campusMajor : campusMajors) {
            CampusMajorDto campusMajorDto = new CampusMajorDto(campusMajor.getCampusMajorId(),
                    campusMajor.getCampus().getName(), "");
            campusMajorDtos.add(campusMajorDto);
        }
        return new ResponseEntity<>(campusMajorDtos, HttpStatus.OK);
    }
}
