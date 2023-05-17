package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.models.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
}
