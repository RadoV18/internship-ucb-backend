package ucb.internship.backend.services;

import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.InstitutionSignUpDto;
import ucb.internship.backend.dtos.VerificationCodeDto;
import ucb.internship.backend.dtos.VerificationCodeReqDto;
import ucb.internship.backend.exceptions.FileStorageException;

import java.util.ArrayList;

public interface SignUpService {

    /**
     * signs up an institution
     * @param institutionSignUpDto the institution to sign up.
     * @param image the logo of the institution that will be used as the profile picture.
     * @return a uuid and the email that will be used to verify the user.
     */
    public VerificationCodeDto institutionSignUp(InstitutionSignUpDto institutionSignUpDto, MultipartFile image) throws FileStorageException;
}
