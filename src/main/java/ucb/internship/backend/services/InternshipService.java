package ucb.internship.backend.services;

import ucb.internship.backend.dtos.InternshipDTO;
import ucb.internship.backend.dtos.MajorDTO;

import java.util.List;

public interface InternshipService {

    String createInternship(InternshipDTO internshipDto);
}
