package ucb.internship.backend.services;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ucb.internship.backend.dtos.InstitucionsDTO;
import ucb.internship.backend.mapper.InstitutionsMAPPER;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.User;
import ucb.internship.backend.repositories.InstitutionRepository;
import ucb.internship.backend.repositories.UserRepository;


@Service
public class InstitutionsService {
    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsService.class);
    private InstitutionRepository institutionsREPOSITORY;
    private UserRepository userREPOSITORY;

    
    @Autowired
    public InstitutionsService(InstitutionRepository institutionsREPOSITORY,
            UserRepository userREPOSITORY) {
        this.institutionsREPOSITORY = institutionsREPOSITORY;
        this.userREPOSITORY = userREPOSITORY;
    }


    public List<InstitucionsDTO> getInstitutions() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de personas");
        List<Institution> result = this.institutionsREPOSITORY.findAll();
        List<InstitucionsDTO> resultDTO = new ArrayList<>();
        result.stream().forEach(institution ->{
            User usuario = this.userREPOSITORY.findById(institution.getUser().getUserId()).orElseThrow();
            InstitucionsDTO institucionsDTO = new InstitucionsDTO();
            institucionsDTO = InstitutionsMAPPER.entityToDto(institution, usuario);
            resultDTO.add(institucionsDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }

    
    
}
