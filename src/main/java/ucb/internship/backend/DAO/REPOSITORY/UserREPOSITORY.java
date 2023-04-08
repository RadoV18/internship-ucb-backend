package ucb.internship.backend.DAO.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.DAO.ENTITY.UserENTITY;

public interface UserREPOSITORY extends JpaRepository<UserENTITY, Integer>{
    
}
