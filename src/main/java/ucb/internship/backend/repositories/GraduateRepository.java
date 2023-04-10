package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.models.GraduateENTITY;

public interface GraduateRepository extends JpaRepository<GraduateENTITY, Integer>{
    
}
