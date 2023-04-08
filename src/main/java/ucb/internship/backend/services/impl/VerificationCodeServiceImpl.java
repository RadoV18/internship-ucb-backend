package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.models.VerificationCode;
import ucb.internship.backend.repositories.VerificationCodeRepository;
import ucb.internship.backend.services.VerificationCodeService;

import java.util.Random;
import java.util.UUID;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Override
    public VerificationCode createVerificationCode() {
        // generate verification code
        Random random = new Random();
        int number = random.nextInt(999999);
        // format as string
        String verificationCode = String.format("%06d", number);
        // uuid to identify the user
        UUID uuid = UUID.randomUUID();
        String uuidIdentifier = uuid.toString();
        VerificationCode verificationCodeObj = new VerificationCode(
                uuidIdentifier, verificationCode, true
        );
        return verificationCodeRepository.save(verificationCodeObj);
    }
}
