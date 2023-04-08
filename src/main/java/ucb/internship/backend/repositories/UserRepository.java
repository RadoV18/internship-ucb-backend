package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.internship.backend.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @param email The user email to look in the database
     * @return the user if it exists, null otherwise
     */
    Optional<User> findByEmail(String email);

    /**
     * saves a user in the database
     * @param user the user to save
     * @return the saved user
     */
    User save(User user);

}
