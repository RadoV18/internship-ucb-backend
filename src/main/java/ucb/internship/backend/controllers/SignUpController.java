package ucb.internship.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ucb.internship.backend.dtos.GraduateDto;
import ucb.internship.backend.dtos.InstitutionSignUpDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.dtos.StudentDto;
import ucb.internship.backend.dtos.VerificationCodeDto;
import ucb.internship.backend.dtos.VerificationCodeReqDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.services.SignUpService;
import ucb.internship.backend.services.VerificationCodeService;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/sign-up")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;
    @Autowired
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification-code")
    public ResponseEntity<ResponseDto<Boolean>> verifyCode(
            @RequestBody VerificationCodeReqDto verificationCodeReqDto) {
        ArrayList<Boolean> result = verificationCodeService.verifyCode(verificationCodeReqDto);
        if (result.get(0)) {
            return ResponseEntity.ok(new ResponseDto<>(result.get(1), null, true));
        }
        return new ResponseEntity<>(new ResponseDto<>(), HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/institution")
    public ResponseEntity<ResponseDto<VerificationCodeDto>> institutionSignUp(
            @RequestParam(value = "data") String data,
            @RequestParam(value = "image") MultipartFile image) throws FileStorageException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InstitutionSignUpDto institutionSignUpDto = objectMapper.readValue(data, InstitutionSignUpDto.class);
            VerificationCodeDto verificationCodeDto = signUpService.institutionSignUp(institutionSignUpDto, image);
            return ResponseEntity.ok(new ResponseDto<>(verificationCodeDto, null, true));
        } catch (IOException e) {
            return ResponseEntity.ok(new ResponseDto<>(null, "Datos inválidos", false));
        }
    }

    @PostMapping("/student")
    public ResponseEntity<ResponseDto<VerificationCodeDto>> studentSignUp(
            @RequestParam(value = "data") String data,
            @RequestParam(value = "profilePicture") MultipartFile profilePicture,
            @RequestParam(value = "cvFile") MultipartFile cvFile) throws FileStorageException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            StudentDto studentDto = objectMapper.readValue(data, StudentDto.class);
            VerificationCodeDto verificationCodeDto = signUpService.studentSignUp(studentDto, profilePicture, cvFile);
            return ResponseEntity.ok(new ResponseDto<>(verificationCodeDto, null, true));
        } catch (IOException e) {
            return ResponseEntity.ok(new ResponseDto<>(null, "Datos inválidos", false));
        }
    }

    @PostMapping("/graduate")
    public ResponseEntity<ResponseDto<VerificationCodeDto>> graduateSignUp(
            @RequestParam(value = "data") String data,
            @RequestParam(value = "profilePicture") MultipartFile profilePicture,
            @RequestParam(value = "cvFile") MultipartFile cvFile) throws FileStorageException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            GraduateDto graduateDto = objectMapper.readValue(data, GraduateDto.class);
            VerificationCodeDto verificationCodeDto = signUpService.graduateSignUp(graduateDto, profilePicture, cvFile);
            return ResponseEntity.ok(new ResponseDto<>(verificationCodeDto, null, true));
        } catch (IOException e) {
            return ResponseEntity.ok(new ResponseDto<>(null, "Datos inválidos", false));
        }
    }

}
