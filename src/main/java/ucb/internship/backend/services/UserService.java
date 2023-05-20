package ucb.internship.backend.services;

import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.User;

public interface UserService
{
    /**
     * @param email The users email
     * @param password The users password
     * @return the user if the email and password are correct, null otherwise
     */
    User authenticate(String email, String password);

    /**
     * Stores a user in the database
     * @param email The user's email
     * @param password The user's password
     * @param profilePicture The user's profile picture
     * @return the stored user
     */
    User createUser(String email, String password, MultipartFile profilePicture) throws FileStorageException;

    /**
     * @param email The user email to look in the database
     * @return the user if it exists, null otherwise
     */
    User getUser(String email);

    /**
     * @return the list of users, may be empty
     */
    Iterable<User> getAllUsers();

    /**
     * checks if a user already exists in the database
     * @param email the email to check
     * @return true if the user exists, false otherwise
     */
    boolean userExists(String email);

    /**
     * @param id The user ID to approve the request
     */
    void setRequestStatus(Long id,Integer state);

}