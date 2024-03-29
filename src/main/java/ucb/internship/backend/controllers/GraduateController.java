package ucb.internship.backend.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import ucb.internship.backend.dtos.GraduateDto;
import ucb.internship.backend.services.GraduateService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/graduates")
public class GraduateController {

    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsController.class);
    private GraduateService graduateBL;

    @Autowired
    public GraduateController(GraduateService graduateBL) {
        this.graduateBL = graduateBL;
    }

    @GetMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<GraduateDto>> getNewGraduates() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de graduados");
        List<GraduateDto> result = graduateBL.getGraduates();
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GraduateDto> requestMethodName(@PathVariable Long id) {
        LOGGER.info("REQUEST: Iniciando petición para obtener el Graduado por id");
        GraduateDto result = graduateBL.getGraduateById(id);
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
