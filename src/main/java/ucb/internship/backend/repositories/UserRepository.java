package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.models.UserENTITY;

public interface UserRepository extends JpaRepository<UserENTITY, Integer>{
    
}
