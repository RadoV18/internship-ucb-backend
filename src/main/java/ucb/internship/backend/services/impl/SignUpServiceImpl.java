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
        Institution institution = new Institution();
        institution.setUserUcb(savedUser);
        institution.setName(institutionSignUpDto.getName());
        institution.setDescription(institutionSignUpDto.getDescription());
        institution.setArea(institutionSignUpDto.getArea());
        institution.setContactFirstName(institutionSignUpDto.getContactFirstName());
        institution.setContactLastName(institutionSignUpDto.getContactLastName());
        institution.setContactEmail(institutionSignUpDto.getContactEmail());
        institution.setContactPhone(institutionSignUpDto.getContactPhone());
        institution.setContactPosition(institutionSignUpDto.getContactPosition());
        institution.setStatus(true);
        institutionRepository.save(institution);

        // generate the verification code
        VerificationCode verificationCode = verificationCodeService.createVerificationCode(savedUser.getUserId());
        Recipient recipient = new Recipient(savedUser.getEmail(), institution.getName());
        sendVerificationCode(recipient, verificationCode.getCode());
        return new VerificationCodeDto(verificationCode.getUuid(), savedUser.getEmail());
    }

    @Override
    public VerificationCodeDto studentSignUp(StudentDto studentDto, MultipartFile profilePicture, MultipartFile cvFile)
            throws FileStorageException {
        // save the user in the database
        String email = studentDto.getPerson().getUser().getEmail();
        String password = studentDto.getPerson().getUser().getPassword();
        User savedUser = userService.createUser(email, password, profilePicture);

        // upload the cv
        S3Object savedS3Object = null;
        if (cvFile != null) {
            savedS3Object = fileStorageService.createObject(cvFile);
        }

        Person newPerson = new Person();
        newPerson.setFirstName(studentDto.getPerson().getFirstName());
        newPerson.setLastName(studentDto.getPerson().getLastName());
        newPerson.setCi(studentDto.getPerson().getCi());
        newPerson.setPhoneNumber(studentDto.getPerson().getPhoneNumber());
        newPerson.setS3Cv(savedS3Object);
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
        String email = graduateDto.getPerson().getUser().getEmail();
        String password = graduateDto.getPerson().getUser().getPassword();
        User savedUser = userService.createUser(email, password, profilePicture);

        // upload the cv
        S3Object savedS3Object = null;
        if (cvFile != null) {
            savedS3Object = fileStorageService.createObject(cvFile);
        }

        Person newPerson = new Person();
        newPerson.setFirstName(graduateDto.getPerson().getFirstName());
        newPerson.setLastName(graduateDto.getPerson().getLastName());
        newPerson.setCi(graduateDto.getPerson().getCi());
        newPerson.setPhoneNumber(graduateDto.getPerson().getPhoneNumber());
        newPerson.setS3Cv(savedS3Object);
        newPerson.setUserUcb(savedUser);
        newPerson.setStatus(true);
        Person savedPerson = personRepository.save(newPerson);

        CampusMajor campusMajor = campusMajorRepository.findById(graduateDto.getCampusMajorId()).orElseThrow();

        Graduate newGraduate = new Graduate();
        newGraduate.setGraduationDate(graduateDto.getGraduationDate());
        newGraduate.setCampusMajor(campusMajor);
        newGraduate.setPerson(savedPerson);
        newGraduate.setStatus(true);
        Graduate savedGraduate = graduateRepository.save(newGraduate);

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
