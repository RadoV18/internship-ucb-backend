package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.models.InstitutionsENTITY;

public interface InstitutionsRepository extends JpaRepository<InstitutionsENTITY,Integer>{
    
}
