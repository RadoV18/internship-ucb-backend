package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ucb.internship.backend.dtos.InstitucionsDto;
import ucb.internship.backend.mapper.InstitutionsMapper;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.User;
import ucb.internship.backend.repositories.InstitutionRepository;
import ucb.internship.backend.repositories.UserRepository;
import ucb.internship.backend.services.InstitutionsService;


@Service
public class InstitutionsServiceImpl implements InstitutionsService{
    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsServiceImpl.class);
    private InstitutionRepository institutionRepository;
    private UserRepository userRepository;

    
    @Autowired
    public InstitutionsServiceImpl(InstitutionRepository institutionRepository,
            UserRepository userRepository) {
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<InstitucionsDto> getInstitutions() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de personas");
        List<Institution> result = this.institutionRepository.findAll();
        List<InstitucionsDto> resultDTO = new ArrayList<>();
        result.stream().forEach(institution ->{
            if (institution.getUserUcb().getIsApproved() ==0) {
                User usuario = this.userRepository.findById(institution.getUserUcb().getUserId()).orElseThrow();
                InstitucionsDto institucionsDTO = new InstitucionsDto();
                institucionsDTO = InstitutionsMapper.entityToDto(institution, usuario);
                resultDTO.add(institucionsDTO);
            }
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }

    @Override
    public void requestApproved(Long id, Integer state) {
        User user = this.userRepository.findById(id).orElseThrow();
        user.setIsApproved(state);
        System.out.println("El usuario es"+ user.getIsApproved());
        this.userRepository.save(user);
    }
    
}
