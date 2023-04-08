package ucb.internship.backend.BL;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SortOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ucb.internship.backend.DAO.ENTITY.InstitutionsENTITY;
import ucb.internship.backend.DAO.ENTITY.UserENTITY;
import ucb.internship.backend.DAO.REPOSITORY.InstitutionsREPOSITORY;
import ucb.internship.backend.DAO.REPOSITORY.UserREPOSITORY;
import ucb.internship.backend.DTO.InstitucionsDTO;
import ucb.internship.backend.DTO.MAPPER.InstitutionsMAPPER;


@Service
public class InstitutionsBL {
    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsBL.class);
    private InstitutionsREPOSITORY institutionsREPOSITORY;
    private UserREPOSITORY userREPOSITORY;

    

    @Autowired
    public InstitutionsBL(InstitutionsREPOSITORY institutionsREPOSITORY, UserREPOSITORY userREPOSITORY) {
        this.institutionsREPOSITORY = institutionsREPOSITORY;
        this.userREPOSITORY = userREPOSITORY;
    }




    public List<InstitucionsDTO> getInstitutions() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de personas");
        List<InstitutionsENTITY> result = this.institutionsREPOSITORY.findAll();
        List<InstitucionsDTO> resultDTO = new ArrayList<>();
        result.stream().forEach(institution ->{
            UserENTITY usuario = this.userREPOSITORY.findById(institution.getUserENTITY().getUser_id()).orElseThrow();
            InstitucionsDTO institucionsDTO = new InstitucionsDTO();
            // institucionsDTO.setArea((institution.getArea()));
            // institucionsDTO.setUser_ucb_id(usuario);
            institucionsDTO = InstitutionsMAPPER.entityToDto(institution, usuario);
            resultDTO.add(institucionsDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }

    
    
}
