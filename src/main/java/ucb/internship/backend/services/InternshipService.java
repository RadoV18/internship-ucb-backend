package ucb.internship.backend.services;

import ucb.internship.backend.dtos.InternshipDto;

public interface InternshipService {

    String createInternship(InternshipDto internshipDto);
}
