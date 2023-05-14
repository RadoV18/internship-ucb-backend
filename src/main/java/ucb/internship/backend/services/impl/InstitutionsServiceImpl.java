package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ucb.internship.backend.dtos.InstitucionsDTO;
import ucb.internship.backend.mapper.InstitutionsMapper;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.User;
import ucb.internship.backend.repositories.InstitutionRepository;
import ucb.internship.backend.repositories.UserRepository;
import ucb.internship.backend.services.InstitutionsService;


@Service
public class InstitutionsServiceImpl implements InstitutionsService{
    private Logger LOGGER = LoggerFactory.getLogger(InstitutionsServiceImpl.class);
    private InstitutionRepository institutionsREPOSITORY;
    private UserRepository userREPOSITORY;

    
    @Autowired
    public InstitutionsServiceImpl(InstitutionRepository institutionsREPOSITORY,
            UserRepository userREPOSITORY) {
        this.institutionsREPOSITORY = institutionsREPOSITORY;
        this.userREPOSITORY = userREPOSITORY;
    }

    @Override
    public List<InstitucionsDTO> getInstitutions() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de personas");
        List<Institution> result = this.institutionsREPOSITORY.findAll();
        List<InstitucionsDTO> resultDTO = new ArrayList<>();
        result.stream().forEach(institution ->{
            User usuario = this.userREPOSITORY.findById(institution.getUserUcb().getUserId()).orElseThrow();
            InstitucionsDTO institucionsDTO = new InstitucionsDTO();
            institucionsDTO = InstitutionsMapper.entityToDto(institution, usuario);
            resultDTO.add(institucionsDTO);
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}",resultDTO);
        return resultDTO;
    }

    @Override
    public void requestApproved(Long id) {
        User user = this.userREPOSITORY.findById(id).orElseThrow();
        user.setApproved(true);
        User updateUser = user;
        System.out.println("El usuario es"+ updateUser.isApproved());
        this.userREPOSITORY.save(updateUser);
    }
    
}
