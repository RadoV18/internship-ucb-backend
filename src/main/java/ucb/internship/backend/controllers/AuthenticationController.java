package ucb.internship.backend.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.PostLoginDTO;
import ucb.internship.backend.models.User;
import ucb.internship.backend.services.UserService;

@RestController
@RequestMapping("/login")
public class AuthenticationController
{
    @Autowired
    UserService userService;

    /**
     * @param body Request body with the user email and password
     * @return the user if the email and password are correct, will serve UNAUTHORIZED otherwise
     */
    @PostMapping
    public ResponseEntity<User> authenticate(@Valid @RequestBody PostLoginDTO body)
    {
        var user = userService.authenticate(body.email(), body.password());

        if ( user == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(user);
    }
}
