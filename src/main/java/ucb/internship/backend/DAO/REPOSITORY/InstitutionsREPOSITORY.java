package ucb.internship.backend.DAO.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.DAO.ENTITY.InstitutionsENTITY;

public interface InstitutionsREPOSITORY extends JpaRepository<InstitutionsENTITY,Integer>{
    
}
