package ucb.internship.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.InstitutionSignUpDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.dtos.VerificationCodeDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.services.SignUpService;

import java.io.IOException;

@RestController
@RequestMapping("/api/sign-up")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/institution")
    public ResponseEntity<ResponseDto<VerificationCodeDto>> institutionSignUp(
        @RequestParam(value = "data") String data,
        @RequestParam(value = "image") MultipartFile image
    ) throws FileStorageException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InstitutionSignUpDto institutionSignUpDto = objectMapper.readValue(data, InstitutionSignUpDto.class);
            VerificationCodeDto verificationCodeDto = signUpService.institutionSignUp(institutionSignUpDto, image);
            return ResponseEntity.ok(new ResponseDto<>(verificationCodeDto, null, true));
        } catch (IOException e) {
            return ResponseEntity.ok(new ResponseDto<>(null, "Datos inválidos", false));
        }
    }

}
