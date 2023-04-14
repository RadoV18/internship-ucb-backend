package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.Graduate;

@Repository
public interface GraduateRepository extends JpaRepository<Graduate, Long> {

}
