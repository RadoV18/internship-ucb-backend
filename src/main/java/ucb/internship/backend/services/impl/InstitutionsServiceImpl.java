package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.dtos.InstitutionsDto;
import ucb.internship.backend.dtos.UserDto;
import ucb.internship.backend.mapper.InstitutionsMapper;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.User;
import ucb.internship.backend.repositories.InstitutionRepository;
import ucb.internship.backend.repositories.UserRepository;
import ucb.internship.backend.services.InstitutionsService;

@Service
public class InstitutionsServiceImpl implements InstitutionsService {
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
    public List<InstitutionsDto> getInstitutions() {
        LOGGER.info("BUSINESS-LOGIC: Iniciando petición para obtener el listado de personas");
        List<Institution> result = this.institutionRepository.findAll();
        List<InstitutionsDto> resultDto = new ArrayList<>();
        result.stream().forEach(institution -> {
            if (institution.getUserUcb().getIsApproved() == 0) {
                User user = this.userRepository.findById(institution.getUserUcb().getUserId()).orElseThrow();
                InstitutionsDto institutionDto = InstitutionsMapper.entityToDto(institution, user);
                resultDto.add(institutionDto);
            }
        });
        LOGGER.info("BUSINESS-LOGIC: EL resultado de la cosnulta es {}", resultDto);
        return resultDto;
    }

    @Override
    public void requestApproved(Long id, Integer state) {
        User user = this.userRepository.findById(id).orElseThrow();
        user.setIsApproved(state);
        System.out.println("El usuario es" + user.getIsApproved());
        this.userRepository.save(user);
    }

    @Override
    public InstitutionsDto getInstitutionById(Long institutionId) {
        Optional<Institution> institution = institutionRepository.findById(institutionId);
        return new InstitutionsDto(institution.get().getInstitutionId(), institution.get().getName(),
                institution.get().getDescription(), institution.get().getArea(),
                institution.get().getContactFirstName(), institution.get().getContactLastName(),
                institution.get().getContactEmail(), institution.get().getContactPhone(),
                institution.get().getContactPosition(), null);
    }

    @Override
    public void updateInstitution(InstitutionsDto institutionsDto) {
        Institution institution = institutionRepository.findById(institutionsDto.getInstitutionId()).orElseThrow();
        institution.setArea(institutionsDto.getArea());
        institution.setDescription(institutionsDto.getDescription());
        institution.setContactFirstName(institutionsDto.getContactFirstName());
        institution.setContactLastName(institutionsDto.getContactLastName());
        institution.setContactPhone(institutionsDto.getContactPhone());
        institution.setContactEmail(institutionsDto.getContactEmail());
        institution.setContactPosition(institutionsDto.getContactPosition());
        institutionRepository.save(institution);
    }

    @Override
    public InstitutionsDto getInstitutionByEmail(String email) {
        Institution institution = institutionRepository.findInstitutionByUserUcbEmail(email);
        UserDto userDto = new UserDto();
        userDto.setS3ProfilePicture(institution.getUserUcb().getS3ProfilePicture().getUrl());
        return new InstitutionsDto(institution.getInstitutionId(), institution.getName(),
                institution.getDescription(), institution.getArea(), institution.getContactFirstName(),
                institution.getContactLastName(), institution.getContactEmail(), institution.getContactPhone(),
                institution.getContactPosition(), userDto);
    }
}
