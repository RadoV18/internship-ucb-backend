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
import ucb.internship.backend.models.CampusMajor;
import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.Person;
import ucb.internship.backend.models.S3Object;
import ucb.internship.backend.models.Student;
import ucb.internship.backend.models.User;
import ucb.internship.backend.models.VerificationCode;
import ucb.internship.backend.repositories.CampusMajorRepository;
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
    @Autowired
    private CampusMajorRepository campusMajorRepository;

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
        String email = studentDto.getPersonDto().getUser().getEmail();
        String password = studentDto.getPersonDto().getUser().getPassword();
        User savedUser = userService.createUser(email, password, profilePicture);

        // upload the cv
        Long s3ObjectId = null;
        if (cvFile != null) {
            S3Object savedS3Object = fileStorageService.createObject(cvFile);
            s3ObjectId = savedS3Object.getS3ObjectId();
        }

        Person newPerson = new Person();
        newPerson.setFirstName(studentDto.getPersonDto().getFirstName());
        newPerson.setLastName(studentDto.getPersonDto().getLastName());
        newPerson.setCi(studentDto.getPersonDto().getCi());
        newPerson.setPhoneNumber(studentDto.getPersonDto().getPhoneNumber());
        newPerson.setS3Cv(s3ObjectId);
        newPerson.setUserUcb(savedUser);
        newPerson.setStatus(true);
        Person savedPerson = personRepository.save(newPerson);

        CampusMajor campusMajor = campusMajorRepository.findById(studentDto.getCampusMajorId()).orElseThrow();

        Student newStudent = new Student();
        newStudent.setSemester(studentDto.getSemester());
        newStudent.setCampusMajor(campusMajor);
        newStudent.setPerson(savedPerson);
        newStudent.setStatus(true);

        studentRepository.save(newStudent);

        // generate the verification code
        VerificationCode verificationCode = verificationCodeService.createVerificationCode(savedUser.getUserId());
        Recipient recipient = new Recipient(savedUser.getEmail(), savedPerson.getFirstName() + " " + savedPerson.getLastName());
        sendVerificationCode(recipient, verificationCode.getCode());
        return new VerificationCodeDto(verificationCode.getUuid(), savedUser.getEmail());
    }

    @Override
    public VerificationCodeDto graduateSignUp(GraduateDto graduateDto, MultipartFile profilePicture,
            MultipartFile cvFile) throws FileStorageException {
        // save the user in the database
        String email = graduateDto.getPersonDto().getUser().getEmail();
        String password = graduateDto.getPersonDto().getUser().getPassword();
        User savedUser = userService.createUser(email, password, profilePicture);

        // upload the cv
        Long s3ObjectId = null;
        if (cvFile != null) {
            S3Object savedS3Object = fileStorageService.createObject(cvFile);
            s3ObjectId = savedS3Object.getS3ObjectId();
        }

        Person newPerson = new Person();
        newPerson.setFirstName(graduateDto.getPersonDto().getFirstName());
        newPerson.setLastName(graduateDto.getPersonDto().getLastName());
        newPerson.setCi(graduateDto.getPersonDto().getCi());
        newPerson.setPhoneNumber(graduateDto.getPersonDto().getPhoneNumber());
        newPerson.setS3Cv(s3ObjectId);
        newPerson.setUserUcb(savedUser);
        newPerson.setStatus(true);
        Person savedPerson = personRepository.save(newPerson);

        CampusMajor campusMajor = campusMajorRepository.findById(graduateDto.getCampusMajorId()).orElseThrow();

        Graduate newGraduate = new Graduate();
        newGraduate.setGraduationDate(graduateDto.getGraduationDate());
        newGraduate.setCampusMajor(campusMajor);
        newGraduate.setPerson(savedPerson);
        newGraduate.setStatus(true);

        // generate the verification code
        VerificationCode verificationCode = verificationCodeService.createVerificationCode(savedUser.getUserId());
        Recipient recipient = new Recipient(savedUser.getEmail(), savedPerson.getFirstName() + " " + savedPerson.getLastName());
        sendVerificationCode(recipient, verificationCode.getCode());
        return new VerificationCodeDto(verificationCode.getUuid(), savedUser.getEmail());
    }

    private void sendVerificationCode(Recipient recipient ,String verificationCode) {
        var mailVariables = new Hashtable<String, String>();
        mailVariables.put(EmailVariables.VERIFICATION_CODE.get(), verificationCode);

        emailService.sendEmail(recipient, mailVariables , Template.VERIFICATION_CODE);
    }
}
