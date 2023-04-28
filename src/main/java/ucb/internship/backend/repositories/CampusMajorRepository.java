package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.CampusMajor;

@Repository
public interface CampusMajorRepository extends JpaRepository<CampusMajor, Long> {

}
