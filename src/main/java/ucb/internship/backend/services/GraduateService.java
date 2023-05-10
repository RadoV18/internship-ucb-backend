package ucb.internship.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Persons;
import ucb.internship.backend.dtos.GraduateDTO;
import ucb.internship.backend.mapper.GraduateMAPPER;
import ucb.internship.backend.repositories.GraduateRepository;
import ucb.internship.backend.repositories.PersonsRepository;

@Service
public class GraduateService {
    
    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsService.class);
    private GraduateRepository graduateREPOSITORY;
    private PersonsRepository personsREPOSITORY;

    
    @Autowired
    public GraduateService(GraduateRepository graduateREPOSITORY, PersonsRepository personsREPOSITORY) {
        this.graduateREPOSITORY = graduateREPOSITORY;
        this.personsREPOSITORY = personsREPOSITORY;
    }

    public List<GraduateDTO> getGraduates() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de instituciones");
        List<Graduate> result = this.graduateREPOSITORY.findAll();
        List<GraduateDTO> resultDTO = new ArrayList<>();
        result.stream().forEach(graduate ->{
            Persons personsENTITY = this.personsREPOSITORY.findById(graduate.getGraduateId()).orElseThrow();
            GraduateDTO graduateDTO = GraduateMAPPER.entityToDto(graduate, personsENTITY);
            resultDTO.add(graduateDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",result);
        return resultDTO;
    }

    public GraduateDTO getGraduateById(Integer id){
        Graduate graduate = this.graduateREPOSITORY.findById(id).orElseThrow();
        Persons person = this.personsREPOSITORY.findById(graduate.getGraduateId()).orElseThrow();
        GraduateDTO graduateDTO = GraduateMAPPER.entityToDto(graduate, person);
        return graduateDTO;
    }
    


}
