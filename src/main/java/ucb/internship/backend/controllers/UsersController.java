package ucb.internship.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import ucb.internship.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ucb.internship.backend.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/users")
public class UsersController
{
    @Autowired
    UserService userService;

    /**
     * @param email The users email to look in the database
     * @return the user, null if it doesn't exist
     */
    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(String email)
    {
        return ResponseEntity.ok(userService.getUser(email));
    }

    /**
     * @return the list of users, may be empty
     */
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping(value = "/{id}/status/{state}")
    public void aprobado(@PathVariable Long id,@PathVariable Integer state) {
        userService.setRequestStatus(id, state);
    }
    
}