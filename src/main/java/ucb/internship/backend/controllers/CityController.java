package ucb.internship.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.internship.backend.dtos.CityDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.services.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<CityDto>>> getCities() {
        List<CityDto> cities = cityService.getAllCities();
        return ResponseEntity.ok(new ResponseDto<>(cities, null, true));
    }
}
