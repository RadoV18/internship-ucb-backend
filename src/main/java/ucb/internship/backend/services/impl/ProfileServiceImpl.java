package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.ProfileDto;
import ucb.internship.backend.exceptions.FileStorageException;
import ucb.internship.backend.models.*;
import ucb.internship.backend.repositories.*;
import ucb.internship.backend.services.FileStorageService;
import ucb.internship.backend.services.ProfileService;

import java.sql.Date;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final PersonRepository personRepository;
    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;
    private final S3ObjectRepository s3ObjectRepository;
    private final UserRepository userRepository;
    private final FileStorageService fileStorageService;
    private final GraduateRepository graduateRepository;
    public static Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
    @Autowired
    public ProfileServiceImpl(PersonRepository personRepository,
                              StudentRepository studentRepository,
                              MajorRepository majorRepository,
                              S3ObjectRepository s3ObjectRepository,
                              UserRepository userRepository, FileStorageService fileStorageService, GraduateRepository graduateRepository) {
        this.personRepository = personRepository;
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
        this.s3ObjectRepository = s3ObjectRepository;
        this.userRepository = userRepository;
        this.fileStorageService = fileStorageService;
        this.graduateRepository = graduateRepository;
    }

    @Override
    public ProfileDto getStudentProfileByEmail(String email) {
        Person person = personRepository.findPersonByEmail(email);
        User user = userRepository.findById(person.getUserId()).orElseThrow();
        S3Object s3Object = s3ObjectRepository.findById(user.getS3ProfilePicture()).orElseThrow();
        Student student = studentRepository.findStudentByPersonId(person.getPersonId());
        Graduate graduate;
        Major major;
        ProfileDto profileDto = new ProfileDto();
        profileDto.setPersonId(person.getPersonId());
        profileDto.setLastName(person.getLastName());
        profileDto.setFirstName(person.getFirstName());
        profileDto.setPhoneNumber(person.getPhoneNumber());
        profileDto.setProfilePicture(s3Object.getUrl());
        profileDto.setCi(person.getCi());
        if(student == null){
            profileDto.setGraduate(true);
            graduate = graduateRepository.findGraduateByPersonId(person.getPersonId());
            major = majorRepository.findMajorByGraduateId(graduate.getGraduateId());
            profileDto.setGraduationDate(graduate.getGraduationDate());
            profileDto.setMajor(major.getName());
        }
        else{
           profileDto.setGraduate(false);
           major = majorRepository.findMajorByStudentId(student.getStudentId());
           profileDto.setSemester(student.getSemester());
           profileDto.setMajor(major.getName());
        }

        return profileDto;
    }

    @Override
    public String updateStudentProfile(ProfileDto profileDto, MultipartFile cv) throws FileStorageException {
        Person person = personRepository.findById(profileDto.getPersonId()).orElseThrow();
        Student student;
        if(!profileDto.isGraduate()){
            student = studentRepository.findStudentByPersonId(person.getPersonId());
            student.setSemester(profileDto.getSemester());
            studentRepository.save(student);
        }
        if(cv != null){
            S3Object s3Object = fileStorageService.createObject(cv);
            person.setS3Cv(s3Object.getS3ObjectId());
            logger.info("CV name {}",cv.getOriginalFilename());
        }
        person.setPhoneNumber(profileDto.getPhoneNumber());
        personRepository.save(person);
        return "Updated";
    }


}
