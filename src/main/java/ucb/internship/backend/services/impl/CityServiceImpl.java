package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.CityDTO;
import ucb.internship.backend.models.City;
import ucb.internship.backend.repositories.CityRepository;
import ucb.internship.backend.services.CityService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDTO> findAllCities() {
        List<City> cities = cityRepository.findAll();

        return cities.stream().map(city -> {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setCityId(city.getCityId());
            cityDTO.setName(city.getName());
            return cityDTO;

        }).collect(Collectors.toList());
    }
}
