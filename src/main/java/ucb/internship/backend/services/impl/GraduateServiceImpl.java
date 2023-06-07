package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.models.Graduate;
import ucb.internship.backend.models.Person;
import ucb.internship.backend.dtos.GraduateDto;
import ucb.internship.backend.mapper.GraduateMapper;
import ucb.internship.backend.repositories.GraduateRepository;
import ucb.internship.backend.repositories.PersonRepository;
import ucb.internship.backend.services.GraduateService;

@Service
public class GraduateServiceImpl implements GraduateService{
    
    private Logger LOGGER = LoggerFactory.getLogger(GraduateServiceImpl.class);
    private GraduateRepository graduateRepository;
    private PersonRepository personRepository;

    
    @Autowired
    public GraduateServiceImpl(GraduateRepository graduateRepository, PersonRepository personsRepository) {
        this.graduateRepository = graduateRepository;
        this.personRepository = personsRepository;
    }

    @Override
    public List<GraduateDto> getGraduates() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de graduados con aprobacion pendiente");
        List<Graduate> result = this.graduateRepository.findAll();
        List<GraduateDto> resultDTO = new ArrayList<>();
        result.stream().forEach(graduate ->{
            if (graduate.getPerson().getUserUcb().getIsApproved() == 0) {
                Person person = this.personRepository.findById(graduate.getPerson().getPersonId()).orElseThrow();
                GraduateDto graduateDTO = GraduateMapper.entityToDto(graduate, person);
                resultDTO.add(graduateDTO);
            }
        });
        return resultDTO;
    }

    @Override
    public GraduateDto getGraduateById(Long id){
        Graduate graduate = this.graduateRepository.findById(id).orElseThrow();
        Person person = this.personRepository.findById(graduate.getPerson().getPersonId()).orElseThrow();
        return GraduateMapper.entityToDto(graduate, person);
    }
}
