package ucb.internship.backend.services;

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
     * @param email The user email to look in the database
     * @return the user if it exists, null otherwise
     */
    User getUser(String email);

    /**
     * @return the list of users, may be empty
     */
    Iterable<User> getAllUsers();
}