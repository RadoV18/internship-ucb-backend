package ucb.internship.backend.services;

import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.AuthDto;
import ucb.internship.backend.dtos.UserDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.User;
import ucb.internship.backend.jwt.payload.response.MessageResponse;
import ucb.internship.backend.jwt.payload.response.TokenRefreshResponse;
import ucb.internship.backend.jwt.payload.request.TokenRefreshRequest;
import ucb.internship.backend.jwt.exception.TokenRefreshException;

public interface UserService {
    /**
     * @param email    The users email
     * @param password The users password
     * @return the user if the email and password are correct, null otherwise
     */
    AuthDto authenticate(String email, String password);

    /**
     * Stores a user in the database
     * 
     * @param email          The user's email
     * @param password       The user's password
     * @param profilePicture The user's profile picture
     * @return the stored user
     */
    User createUser(String email, String password, MultipartFile profilePicture, String role)
            throws FileStorageException;

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
     * 
     * @param email the email to check
     * @return true if the user exists, false otherwise
     */
    boolean userExists(String email);

    /**
     * @param id The user ID to approve the request
     */
    void setRequestStatus(Long id, Integer state);

    /**
     * @param request The request contains the refresh token from user
     * @return the refresh token response, refresh toke exception otherwise
     */

    public TokenRefreshResponse getRefreshtoken(TokenRefreshRequest request) throws TokenRefreshException;

    /**
     * @return log out message response
     */

    public MessageResponse getLogoutUser();

}