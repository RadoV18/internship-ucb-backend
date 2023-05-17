package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
