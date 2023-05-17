package ucb.internship.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.dtos.CampusDto;
import ucb.internship.backend.dtos.MajorCustomDto;
import ucb.internship.backend.models.Campus;
import ucb.internship.backend.models.CampusMajor;
import ucb.internship.backend.repositories.CampusRepository;

@RestController
@RequestMapping("/api/campus")
public class CampusController {
    @Autowired
    private CampusRepository campusRepository;

    @GetMapping
    public ResponseEntity<List<CampusDto>> getCampusMajor() {
        List<Campus> campuses = this.campusRepository.findAll();
        List<CampusDto> campusDtos = new ArrayList<>();
        for (Campus campus : campuses) {
            List<CampusMajor> campusMajors = campus.getCampusMajors();
            List<MajorCustomDto> majorCustomDtos = new ArrayList<>();
            for (CampusMajor campusMajor : campusMajors) {
                MajorCustomDto majorCustomDto = new MajorCustomDto(campusMajor.getCampusMajorId(),
                        campusMajor.getMajor().getName());
                majorCustomDtos.add(majorCustomDto);
            }
            CampusDto campusDto = new CampusDto(campus.getCampusId(), campus.getName(), majorCustomDtos);
            campusDtos.add(campusDto);
        }
        return new ResponseEntity<>(campusDtos, HttpStatus.OK);
    }
}
