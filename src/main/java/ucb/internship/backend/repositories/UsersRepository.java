package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ucb.internship.backend.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long>
{
    /**
     * @param email The user email to look in the database
     * @return the user if it exists, null otherwise
     */
    Optional<User> findByEmail(String email);
}
