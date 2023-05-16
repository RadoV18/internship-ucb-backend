package ucb.internship.backend.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ucb.internship.backend.dtos.GraduateDto;
import ucb.internship.backend.dtos.InstitutionSignUpDto;
import ucb.internship.backend.dtos.StudentDto;
import ucb.internship.backend.dtos.VerificationCodeDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.mailing.EmailVariables;
import ucb.internship.backend.mailing.Recipient;
import ucb.internship.backend.mailing.Template;
import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.Person;
import ucb.internship.backend.models.S3Object;
import ucb.internship.backend.models.Student;
import ucb.internship.backend.models.User;
import ucb.internship.backend.models.VerificationCode;
import ucb.internship.backend.repositories.GraduateRepository;
import ucb.internship.backend.repositories.InstitutionRepository;
import ucb.internship.backend.repositories.PersonRepository;
import ucb.internship.backend.repositories.StudentRepository;
import ucb.internship.backend.services.*;

import java.util.Hashtable;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UserService userService;
    @Autowired
    private VerificationCodeService verificationCodeService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GraduateRepository graduateRepository;

    @Override
    public VerificationCodeDto institutionSignUp(
            InstitutionSignUpDto institutionSignUpDto,
            MultipartFile image) throws FileStorageException {
        User savedUser = userService.createUser(institutionSignUpDto.getEmail(), institutionSignUpDto.getPassword(),
                image);
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
                institutionSignUpDto.getContactPosition(),
                true
        );
        institutionRepository.save(institution);
        // generate the verification code
        VerificationCode verificationCode = verificationCodeService.createVerificationCode(savedUser.getUserId());

        var recipient = new Recipient(savedUser.getEmail(), institution.getName());

        sendVerificationCode(recipient, verificationCode.getCode());

        return new VerificationCodeDto(verificationCode.getUuid(), savedUser.getEmail());
    }

    @Override
    public VerificationCodeDto studentSignUp(StudentDto studentDto, MultipartFile profilePicture, MultipartFile cvFile)
            throws FileStorageException {
        // save the user in the database
        String email = studentDto.getPersonDto().getUserDto().getEmail();
        String password = studentDto.getPersonDto().getUserDto().getPassword();
        User savedUser = userService.createUser(email, password, profilePicture);
        // upload the cv
        Long s3ObjectId = null;
        if (cvFile != null) {
            S3Object savedS3Object = fileStorageService.createObject(cvFile);
            s3ObjectId = savedS3Object.getS3ObjectId();
        }

        // TODO: save the person in the database using cv_id from cv
        // TODO: save the graduate in the database using person_id
        Person person = personRepository.save(new Person(null, savedUser.getUserId(),
                studentDto.getPersonDto().getFirstName(), studentDto.getPersonDto().getLastName(),
                studentDto.getPersonDto().getCi(), studentDto.getPersonDto().getPhoneNumber(), s3ObjectId));

        studentRepository.save(new Student(null, person.getPersonId(), studentDto.getCampusMajorId(),
                studentDto.getSemester()));

        // generate the verification code
        VerificationCode verificationCode = verificationCodeService.createVerificationCode(savedUser.getUserId());

        var recipient = new Recipient(savedUser.getEmail(), person.getFullName());

        sendVerificationCode(recipient, verificationCode.getCode());

        return new VerificationCodeDto(verificationCode.getUuid(), savedUser.getEmail());
    }

    @Override
    public VerificationCodeDto graduateSignUp(GraduateDto graduateDto, MultipartFile profilePicture,
            MultipartFile cvFile) throws FileStorageException {
        // save the user in the database
        String email = graduateDto.getPersonDto().getUserDto().getEmail();
        String password = graduateDto.getPersonDto().getUserDto().getPassword();
        User savedUser = userService.createUser(email, password, profilePicture);
        // upload the cv
        Long s3ObjectId = null;
        if (cvFile != null) {
            S3Object savedS3Object = fileStorageService.createObject(cvFile);
            s3ObjectId = savedS3Object.getS3ObjectId();
        }

        // TODO: save the person in the database using cv_id from cv
        // TODO: save the graduate in the database using person_id
        Person person = personRepository.save(new Person(null, savedUser.getUserId(),
                graduateDto.getPersonDto().getFirstName(), graduateDto.getPersonDto().getLastName(),
                graduateDto.getPersonDto().getCi(), graduateDto.getPersonDto().getPhoneNumber(), s3ObjectId));

        graduateRepository.save(new Graduate(null, person.getPersonId(),
                graduateDto.getGraduationDate(), graduateDto.getCampusMajorId()));

        // generate the verification code
        VerificationCode verificationCode = verificationCodeService.createVerificationCode(savedUser.getUserId());

        var recipient = new Recipient(savedUser.getEmail(), person.getFullName());

        sendVerificationCode(recipient, verificationCode.getCode());

        return new VerificationCodeDto(verificationCode.getUuid(), savedUser.getEmail());
    }

    private void sendVerificationCode(Recipient recipient ,String verificationCode) {
        var mailVariables = new Hashtable<String, String>();
        mailVariables.put(EmailVariables.VERIFICATION_CODE.get(), verificationCode);

        emailService.sendEmail(recipient, mailVariables , Template.VERIFICATION_CODE);
    }
}
