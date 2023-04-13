package ucb.internship.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.internship.backend.services.impl.CityServiceImpl;

@RestController
public class CityController {
    public CityServiceImpl cityService;
    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public Object findAllCities() {
        return cityService.findAllCities();
    }
}
