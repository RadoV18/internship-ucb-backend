package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.internship.backend.models.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    
}
