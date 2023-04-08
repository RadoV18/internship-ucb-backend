package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ucb.internship.backend.models.Internship;

import java.util.List;

@Repository
@Service
public interface InternshipRepository  extends JpaRepository<Internship, Integer> {
    public List<Internship> findByInternshipId(Integer InternshipId);
}
