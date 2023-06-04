package ucb.internship.backend.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.AuthDto;
import ucb.internship.backend.dtos.PostLoginDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.dtos.UserDto;
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
    public ResponseEntity<ResponseDto<AuthDto>> authenticate(@Valid @RequestBody PostLoginDto body) {
        AuthDto user = userService.authenticate(body.email(), body.password());

        if ( user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(new ResponseDto<>(user, null, true));
    }
}
