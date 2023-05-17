package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Persons;
import ucb.internship.backend.dtos.GraduateDto;
import ucb.internship.backend.mapper.GraduateMapper;
import ucb.internship.backend.repositories.GraduateRepository;
import ucb.internship.backend.repositories.PersonsRepository;
import ucb.internship.backend.services.GraduateService;

@Service
public class GraduateServiceImpl implements GraduateService{
    
    private Logger LOGGER = LoggerFactory.getLogger(GraduateServiceImpl.class);
    private GraduateRepository graduateREPOSITORY;
    private PersonsRepository personsREPOSITORY;

    
    @Autowired
    public GraduateServiceImpl(GraduateRepository graduateREPOSITORY, PersonsRepository personsREPOSITORY) {
        this.graduateREPOSITORY = graduateREPOSITORY;
        this.personsREPOSITORY = personsREPOSITORY;
    }

    @Override
    public List<GraduateDto> getGraduates() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de instituciones");
        List<Graduate> result = this.graduateREPOSITORY.findAll();
        List<GraduateDto> resultDTO = new ArrayList<>();
        result.stream().forEach(graduate ->{
            if (graduate.getPerson().getUserUcb().getApproved() == 0) {
                Persons personsENTITY = this.personsREPOSITORY.findById(graduate.getGraduateId()).orElseThrow();
                GraduateDto graduateDTO = GraduateMapper.entityToDto(graduate, personsENTITY);
                resultDTO.add(graduateDTO);
            }
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",result);
        return resultDTO;
    }

    @Override
    public GraduateDto getGraduateById(Integer id){
        Graduate graduate = this.graduateREPOSITORY.findById(id).orElseThrow();
        Persons person = this.personsREPOSITORY.findById(graduate.getGraduateId()).orElseThrow();
        GraduateDto graduateDTO = GraduateMapper.entityToDto(graduate, person);
        return graduateDTO;
    }
    


}