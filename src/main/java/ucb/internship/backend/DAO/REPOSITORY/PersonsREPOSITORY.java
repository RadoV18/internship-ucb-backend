package ucb.internship.backend.DAO.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.DAO.ENTITY.PersonsENTITY;

public interface PersonsREPOSITORY extends JpaRepository<PersonsENTITY, Integer>{
    
}
