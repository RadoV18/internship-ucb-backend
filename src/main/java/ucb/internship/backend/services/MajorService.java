package ucb.internship.backend.services;

import ucb.internship.backend.dtos.MajorDTO;
import java.util.List;
public interface MajorService {
    List<MajorDTO> findAllMajors();
}
