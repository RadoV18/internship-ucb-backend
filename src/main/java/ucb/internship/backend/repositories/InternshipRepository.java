package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.ActiveInternshipDto;
import ucb.internship.backend.models.Internship;

import java.util.List;

@Repository
public interface InternshipRepository  extends JpaRepository<Internship, Integer> {
    List<Internship> findByInternshipId(Integer InternshipId);

    List<Internship> findAllByInstitutionIdAndIsApprovedIs(Integer institutionId, Integer isApproved);
}
