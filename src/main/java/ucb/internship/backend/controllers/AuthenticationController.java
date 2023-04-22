package ucb.internship.backend.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.PostLoginDTO;
import ucb.internship.backend.mailing.EmailVariables;
import ucb.internship.backend.mailing.Recipient;
import ucb.internship.backend.mailing.Template;
import ucb.internship.backend.models.User;
import ucb.internship.backend.services.EmailService;
import ucb.internship.backend.services.UserService;

import java.util.Hashtable;

@RestController
@RequestMapping("/login")
public class AuthenticationController
{
    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;
    /**
     * @param body Request body with the user email and password
     * @return the user if the email and password are correct, will serve UNAUTHORIZED otherwise
     */
    @PostMapping
    public ResponseEntity<User> authenticate(@Valid @RequestBody PostLoginDTO body)
    {
        var aux = new Hashtable<String, String>();
        aux.put(EmailVariables.VERIFICATION_CODE.get(), "469831");

        emailService.sendEmail(new Recipient("maofloresp@gmail.com", "Maofloresp"), aux , Template.VERIFICATION_CODE);

        var user = userService.authenticate(body.email(), body.password());

        if ( user == null)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(user);
    }
}
