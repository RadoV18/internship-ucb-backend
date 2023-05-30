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

@Service
public class ProfileServiceImpl implements ProfileService {

    private final PersonRepository personRepository;
    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;
    private final FileStorageService fileStorageService;
    private final GraduateRepository graduateRepository;
    public static Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
    @Autowired
    public ProfileServiceImpl(PersonRepository personRepository,
                              StudentRepository studentRepository,
                              MajorRepository majorRepository,
                              FileStorageService fileStorageService,
                              GraduateRepository graduateRepository
    ) {
        this.personRepository = personRepository;
        this.studentRepository = studentRepository;
        this.majorRepository = majorRepository;
        this.fileStorageService = fileStorageService;
        this.graduateRepository = graduateRepository;
    }

    @Override
    public ProfileDto getStudentProfileByEmail(String email) {
        Person person = personRepository.findPersonByEmail(email);
        S3Object s3Object = person.getUserUcb().getS3ProfilePicture();
        Student student = studentRepository.findStudentByPerson(person);
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
            graduate = graduateRepository.findGraduateByPerson(person);
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
            student = studentRepository.findStudentByPerson(person);
            student.setSemester(profileDto.getSemester());
            studentRepository.save(student);
        }
        if(cv != null){
            S3Object s3Object = fileStorageService.createObject(cv);
            person.setS3Cv(s3Object);
            logger.info("CV name {}",cv.getOriginalFilename());
        }
        person.setPhoneNumber(profileDto.getPhoneNumber());
        personRepository.save(person);
        return "Updated";
    }
}
