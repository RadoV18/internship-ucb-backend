package ucb.internship.backend.services;

import ucb.internship.backend.exceptions.MailServiceException;

public interface EmailService {
    /**
     * Sends a verification code to the user
     * 
     * @param email the user to send the verification code to.
     * @param code  the verification code.
     */
    public void sendVerificationCode(String email, String code) throws MailServiceException;
}
