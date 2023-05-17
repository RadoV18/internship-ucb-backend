package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.CityDto;
import ucb.internship.backend.mappers.CityMapper;
import ucb.internship.backend.models.City;
import ucb.internship.backend.repositories.CityRepository;
import ucb.internship.backend.services.CityService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    public CityRepository cityRepository;

    @Override
    public List<CityDto> getAllCities() {
        ArrayList<CityDto> result = new ArrayList<>();
        List<City> cities = cityRepository.findAll();
        for(City city : cities) {
            result.add(CityMapper.entityToDto(city));
        }
        return result;
    }
}
