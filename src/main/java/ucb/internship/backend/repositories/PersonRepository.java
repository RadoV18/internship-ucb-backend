package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query(value = "Select p from Person p , User u where p.userUcb.userId = u.userId and u.email like :email" )
    Person findPersonByEmail(String email);
}
