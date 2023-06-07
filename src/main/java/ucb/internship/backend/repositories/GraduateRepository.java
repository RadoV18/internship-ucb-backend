package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Person;

@Repository
public interface GraduateRepository extends JpaRepository<Graduate, Long> {
    Graduate findGraduateByPerson(Person person);
}
