package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.VerificationCodeReqDto;
import ucb.internship.backend.models.User;
import ucb.internship.backend.models.VerificationCode;
import ucb.internship.backend.repositories.UserRepository;
import ucb.internship.backend.repositories.VerificationCodeRepository;
import ucb.internship.backend.services.VerificationCodeService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private final Logger logger = LoggerFactory.getLogger(VerificationCodeServiceImpl.class);
    @Autowired
    private VerificationCodeRepository verificationCodeRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public VerificationCode createVerificationCode(Long userId) {
        // generate verification code
        Random random = new Random();
        int number = random.nextInt(999999);
        // format as string
        String verificationCode = String.format("%06d", number);
        // uuid to identify the user
        UUID uuid = UUID.randomUUID();
        String uuidIdentifier = uuid.toString();
        VerificationCode verificationCodeObj = new VerificationCode(
                uuidIdentifier, verificationCode, userId, true
        );
        return verificationCodeRepository.save(verificationCodeObj);
    }

    @Override
    public ArrayList<Boolean> verifyCode(VerificationCodeReqDto verificationCodeReqDto) {
        ArrayList<Boolean> result = new ArrayList<>();
        logger.info("retrieving code from database");
        VerificationCode code = verificationCodeRepository.findByUuidAndStatusIs(verificationCodeReqDto.getUuid(), true);
        if(code == null) {
            logger.info("invalid code");
            result.add(false);
            result.add(false);
            return result;
        }
        if(code.getCode().equals(verificationCodeReqDto.getCode())) {
            logger.info("successfully checked code");
            result.add(true);
            // check if the user is a student
            logger.info("checking user data");
            User student = userRepository.checkUserIsStudent(code.getUserId());
            if(student != null) {
                // doesn't need verification
                result.add(false);
            } else {
                // needs verification
                result.add(true);
            }
            logger.info("deleting verification code from database");
            // delete the code
            verificationCodeRepository.deleteById(code.getVerificationCodeId());
        } else {
            logger.info("invalid code");
            result.add(false);
            result.add(false);
        }
        return result;
    }

    
}
