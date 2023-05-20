package ucb.internship.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.models.Student;
import ucb.internship.backend.repositories.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id){
        return this.studentRepository.findById(id).orElseThrow(); 
    }
    
    
}
