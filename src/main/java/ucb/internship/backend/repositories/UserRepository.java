package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.models.User;

import java.util.Optional;

@Repository
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

    /**
     * @param userId the Id of the user
     * @return the user
     */
    @Query(value = """
    SELECT u.* FROM UCB_USER u
    INNER JOIN PERSON p
        ON p.user_id = u.user_id
    INNER JOIN STUDENT s
        ON p.person_id = s.person_id
    WHERE
        u.user_id = :userId
        AND u.status = TRUE
    """, nativeQuery = true)
    User checkUserIsStudent(Long userId);

}
