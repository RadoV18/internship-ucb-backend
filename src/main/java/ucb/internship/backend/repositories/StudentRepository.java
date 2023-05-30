package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.Person;
import ucb.internship.backend.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByPerson(Person person);

}
