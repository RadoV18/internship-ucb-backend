package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.CityDto;
import ucb.internship.backend.models.City;

public class CityMapper {

    public static CityDto entityToDto(City city) {
        return new CityDto(city.getCityId(), city.getName());
    }
}
