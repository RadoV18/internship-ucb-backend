package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.models.Persons;

public interface PersonsRepository extends JpaRepository<Persons, Integer>{
    
}
