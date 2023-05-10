package ucb.internship.backend.controllers;

import java.util.List;

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

import ucb.internship.backend.dtos.GraduateDTO;
import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.services.GraduateService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("admin/graduates")
public class GraduateController {
    
    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsController.class);
    private GraduateService graduateBL;

    @Autowired
    public GraduateController(GraduateService graduateBL) {
        this.graduateBL = graduateBL;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<GraduateDTO>> get_graduates() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de graduados");
        List<GraduateDTO> result = graduateBL.getGraduates();
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<GraduateDTO> requestMethodName(@PathVariable Integer id) {
        LOGGER.info("REQUEST: Iniciando petición para obtener el Graduado por id");
        GraduateDTO result = graduateBL.getGraduateById(id);
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    

    
}
