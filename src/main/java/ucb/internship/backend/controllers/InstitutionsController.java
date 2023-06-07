package ucb.internship.backend.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ucb.internship.backend.dtos.InstitutionsDto;
import ucb.internship.backend.dtos.ResponseDto;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<InstitutionsDto>> get_institutions() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de instituciones");
        List<InstitutionsDto> result = institutionsBL.getInstitutions();
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/{institutionId}")
    public ResponseEntity<InstitutionsDto> getInstitutionByIdDto(@PathVariable Long institutionId) {
        InstitutionsDto institutionsDto = institutionsBL.getInstitutionById(institutionId);
        return new ResponseEntity<>(institutionsDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseDto<String>> updateInstitution(@RequestBody InstitutionsDto institutionDto) {
        try {
            institutionsBL.updateInstitution(institutionDto);
            ResponseDto<String> responseDto = new ResponseDto<>(null, "Institucion actualizada correctamente", true);
            return new ResponseEntity<ResponseDto<String>>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<InstitutionsDto> getInstitutionByEmail(@PathVariable String email) {
        InstitutionsDto institutionsDto = institutionsBL.getInstitutionByEmail(email);
        return new ResponseEntity<>(institutionsDto, HttpStatus.OK);
    }
}
