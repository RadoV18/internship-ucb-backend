package ucb.internship.backend.services;

import ucb.internship.backend.dtos.MajorDto;

import java.util.List;

public interface MajorService {

    /**
     * Gets all the majors from the database
     * @param sort the sort criteria
     * @return the list of majors
     */
    List<MajorDto> getAllMajors(String sort);
}
