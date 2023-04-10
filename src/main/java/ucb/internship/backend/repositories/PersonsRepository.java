package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.models.PersonsENTITY;

public interface PersonsRepository extends JpaRepository<PersonsENTITY, Integer>{
    
}
