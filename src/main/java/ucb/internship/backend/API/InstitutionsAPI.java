package ucb.internship.backend.API;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.BL.InstitutionsBL;
import ucb.internship.backend.DAO.ENTITY.InstitutionsENTITY;
import ucb.internship.backend.DTO.InstitucionsDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("obtener/instituciones")
public class InstitutionsAPI {

    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsAPI.class);
    private InstitutionsBL institutionsBL;

    @Autowired
    public InstitutionsAPI(InstitutionsBL institutionsBL) {
        this.institutionsBL = institutionsBL;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<InstitucionsDTO>> get_institutions() {
        LOGGER.info("REQUEST: Iniciando petición para obtener el listado de instituciones");
        List<InstitucionsDTO> result = institutionsBL.getInstitutions();
        LOGGER.info("REQUEST: El resultado de la consulta es {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
}
