package ucb.internship.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.internship.backend.dtos.CityDTO;
import ucb.internship.backend.services.impl.CityServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CityController {
    public CityServiceImpl cityService;
    @Autowired
    private CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }
    public Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    @GetMapping("/city")
    public ResponseEntity<List<CityDTO>> findAllCities() {
        try{
            return new ResponseEntity<>(cityService.findAllCities(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
