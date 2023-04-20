package ucb.internship.backend.services;

import ucb.internship.backend.dtos.MajorDto;
import java.util.List;
public interface MajorService {
    List<MajorDto> findAllMajors();
}
