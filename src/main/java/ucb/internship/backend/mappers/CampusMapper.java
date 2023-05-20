package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.CampusDto;
import ucb.internship.backend.models.Campus;

public class CampusMapper {
    public static CampusDto entityToDto(Campus campus) {
        return new CampusDto(campus.getCampusId(), campus.getName(), null);
    }
}
