package ucb.internship.backend.services;

import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.CityDTO;
import ucb.internship.backend.models.City;

import java.util.List;
@Service
public interface CityService {
    public List<CityDTO> findAllCities();
}
