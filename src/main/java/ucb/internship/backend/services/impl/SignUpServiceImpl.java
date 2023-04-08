package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.InstitutionSignUpDto;
import ucb.internship.backend.dtos.VerificationCodeDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.User;
import ucb.internship.backend.models.VerificationCode;
import ucb.internship.backend.repositories.InstitutionRepository;
import ucb.internship.backend.services.*;
@Service
public class SignUpServiceImpl implements SignUpService {

    private final Logger logger = LoggerFactory.getLogger(SignUpServiceImpl.class);
    @Autowired
    private UserService userService;
    @Autowired
    private VerificationCodeService verificationCodeService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private InstitutionRepository institutionRepository;

    @Override
    public VerificationCodeDto institutionSignUp(
        InstitutionSignUpDto institutionSignUpDto,
        MultipartFile image
    ) throws FileStorageException {
        User savedUser = userService.createUser(institutionSignUpDto.getEmail(),institutionSignUpDto.getPassword(), image);
        // save the institution in the database
        Institution institution = new Institution(
            savedUser.getUserId(),
            institutionSignUpDto.getName(),
            institutionSignUpDto.getDescription(),
            institutionSignUpDto.getArea(),
            institutionSignUpDto.getContactFirstName(),
            institutionSignUpDto.getContactLastName(),
            institutionSignUpDto.getContactEmail(),
            institutionSignUpDto.getContactPhone(),
            institutionSignUpDto.getContactPosition()
        );
        institutionRepository.save(institution);
        // generate the verification code
        VerificationCode verificationCode = verificationCodeService.createVerificationCode(savedUser.getUserId());
        // send verification code to the email
        Thread mailThread = new Thread(() -> {
            try {
                emailService.sendVerificationCode(savedUser.getEmail(), verificationCode.getCode());
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Error sending verification code.");
            }
        });
        mailThread.start();
        return new VerificationCodeDto(verificationCode.getUuid(), savedUser.getEmail());
    }
}
