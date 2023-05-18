package ucb.internship.backend.mappers;

import ucb.internship.backend.dtos.MajorDto;
import ucb.internship.backend.models.Major;

public class MajorMapper {

    public static MajorDto entityToDto(Major major) {
        return new MajorDto(major.getMajorId(), major.getName());
    }
}
