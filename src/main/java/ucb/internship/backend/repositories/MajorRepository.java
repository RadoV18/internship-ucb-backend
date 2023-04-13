package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ucb.internship.backend.models.Major;
@Repository
@Service
public interface MajorRepository extends JpaRepository<Major, Integer>{
}
