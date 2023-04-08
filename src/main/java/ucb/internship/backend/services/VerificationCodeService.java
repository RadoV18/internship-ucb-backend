package ucb.internship.backend.services;

import ucb.internship.backend.models.VerificationCode;

public interface VerificationCodeService {
    /**
     * creates a verification code
     * @returns the created verification code
     */
    VerificationCode createVerificationCode();
}
