package ucb.internship.backend.services;

import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.CityDto;

import java.util.List;
@Service
public interface CityService {
    public List<CityDto> findAllCities();
}
