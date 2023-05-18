package ucb.internship.backend.services;

import ucb.internship.backend.dtos.CityDto;

import java.util.List;

public interface CityService {

    /**
     * Gets all the cities from the database
     * @return a list of cities
     */
    List<CityDto> getAllCities();
}
