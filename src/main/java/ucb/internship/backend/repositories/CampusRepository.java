package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.Campus;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {

}
