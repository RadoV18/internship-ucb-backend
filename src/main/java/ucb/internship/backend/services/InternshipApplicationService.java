package ucb.internship.backend.services;

import ucb.internship.backend.dtos.InternshipApplicationDto;

public interface InternshipApplicationService {
    InternshipApplicationDto applyToInternship(InternshipApplicationDto internshipApplicationDto);
}
