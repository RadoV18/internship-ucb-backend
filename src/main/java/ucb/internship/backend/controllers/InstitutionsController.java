package ucb.internship.backend.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.InstitutionsDto;
import ucb.internship.backend.services.InstitutionsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/institutions")
public class InstitutionsController {

    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsController.class);
    private InstitutionsService institutionsBL;

    @Autowired
    public InstitutionsController(InstitutionsService institutionsBL) {
        this.institutionsBL = institutionsBL;
    }

    @GetMapping("/new")
    public ResponseEntity<List<InstitutionsDto>> get_institutions() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de instituciones");
        List<InstitutionsDto> result = institutionsBL.getInstitutions();
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
