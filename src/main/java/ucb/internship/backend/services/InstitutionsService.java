package ucb.internship.backend.services;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.models.InstitutionsENTITY;
import ucb.internship.backend.models.UserENTITY;
import ucb.internship.backend.dtos.InstitucionsDTO;
import ucb.internship.backend.mapper.InstitutionsMAPPER;
import ucb.internship.backend.repositories.InstitutionsRepository;
import ucb.internship.backend.repositories.UserRepository;


@Service
public class InstitutionsService {
    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsService.class);
    private InstitutionsRepository institutionsREPOSITORY;
    private UserRepository userREPOSITORY;

    

    @Autowired
    public InstitutionsService(InstitutionsRepository institutionsREPOSITORY, UserRepository userREPOSITORY) {
        this.institutionsREPOSITORY = institutionsREPOSITORY;
        this.userREPOSITORY = userREPOSITORY;
    }




    public List<InstitucionsDTO> getInstitutions() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de personas");
        List<InstitutionsENTITY> result = this.institutionsREPOSITORY.findAll();
        List<InstitucionsDTO> resultDTO = new ArrayList<>();
        result.stream().forEach(institution ->{
            UserENTITY usuario = this.userREPOSITORY.findById(institution.getUserENTITY().getUserId()).orElseThrow();
            InstitucionsDTO institucionsDTO = new InstitucionsDTO();
            institucionsDTO = InstitutionsMAPPER.entityToDto(institution, usuario);
            resultDTO.add(institucionsDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }

    
    
}
