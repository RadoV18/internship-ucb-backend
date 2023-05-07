package ucb.internship.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.models.Student;
import ucb.internship.backend.services.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
class StudentController {

    private StudentService studentService;
    Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        LOGGER.info("REQUEST: Iniciando petición para obtener un estudiante");
        Student result = studentService.getStudentById(id);
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    



}
