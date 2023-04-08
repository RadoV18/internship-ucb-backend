package ucb.internship.backend.services;

import ucb.internship.backend.dtos.VerificationCodeReqDto;
import ucb.internship.backend.models.VerificationCode;

import java.util.ArrayList;

public interface VerificationCodeService {
    /**
     * creates a verification code
     * @param userId the id of the user
     * @returns the created verification code
     */
    VerificationCode createVerificationCode(Long userId);

    /**
     * verifies the code sent by a user
     * @param verificationCodeReqDto the uuid and the code
     * @returns two boolean values, the first if it was succesful and the second
     * if the user needs to be approved by an admin
     */
    ArrayList<Boolean> verifyCode(VerificationCodeReqDto verificationCodeReqDto);
}
