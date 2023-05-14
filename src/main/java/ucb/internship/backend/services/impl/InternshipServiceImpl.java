package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.dtos.InternshipApiDto;
import ucb.internship.backend.dtos.InternshipDTO;
import ucb.internship.backend.mapper.InternshipMapper;
import ucb.internship.backend.models.City;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.Internship;
import ucb.internship.backend.models.InternshipMajor;
import ucb.internship.backend.repositories.CityRepository;
import ucb.internship.backend.repositories.InstitutionRepository;
import ucb.internship.backend.repositories.InternshipRepository;
import ucb.internship.backend.services.InternshipService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InternshipServiceImpl implements InternshipService{
    private final InternshipRepository internshipRepository;
    private final CityRepository cityRepository;
    private final InstitutionRepository institutionRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(InternshipServiceImpl.class.getName());

    @Autowired
    public InternshipServiceImpl(InternshipRepository internshipRepository, CityRepository cityRepository,
            InstitutionRepository institutionRepository) {
        this.internshipRepository = internshipRepository;
        this.cityRepository = cityRepository;
        this.institutionRepository = institutionRepository;
    }

    @Override
    public String createInternship(InternshipDTO internshipDto) {
        try {
            City city = cityRepository.findById(internshipDto.getCityId()).orElseThrow();
            Institution institution = institutionRepository.findById(internshipDto.getInstitutionId()).orElseThrow();
            Internship newInternship = new Internship();
            newInternship.setTitle(internshipDto.getTitle());
            newInternship.setDescription(internshipDto.getDescription());
            newInternship.setIsApproved(0);
            newInternship.setInstitutionId(institution);
            newInternship.setStatus(1);
            newInternship.setStartingDate(internshipDto.getStartingDate());
            newInternship.setEndingDate(internshipDto.getEndingDate());
            newInternship.setCityId(city);
            newInternship.setInternshipBenefits(internshipDto.getInternshipBenefits().stream().map(benefit -> {
                benefit.setInternship(newInternship);
                benefit.setStatus(1);
                return benefit;
            }).toList());

            newInternship.setInternshipRequirements(internshipDto.getInternshipRequirements().stream().map(requirement -> {
                requirement.setInternship(newInternship);
                requirement.setStatus(1);
                return requirement;
            }).toList());
            newInternship.setInternshipRoles(internshipDto.getInternshipRoles().stream().map(role -> {
                role.setInternship(newInternship);
                role.setStatus(1);
                return role;
            }).toList());
            newInternship.setMajorList(internshipDto.getMajorList().stream().map(
                    major -> new InternshipMajor(newInternship, major, 1)).toList());
            LOGGER.info("Internship {}", newInternship);
            internshipRepository.save(newInternship);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating internship";

        }
        return "Internship created successfully";
    }

    @Override
    public InternshipApiDto getInternshipApiById(Integer id){
        Internship gInternship = internshipRepository.findById(id).orElseThrow();
        InternshipApiDto newInternshipApiDto = InternshipMapper.entityToApiDto(gInternship);
        return  newInternshipApiDto;
    }

    @Override
    public List<InternshipApiDto> getInternshipAll(){
        List<InternshipApiDto> listInternship = new ArrayList<>();
        List<Internship> list = internshipRepository.findByIsApproved(0);
        for (Internship convocatory : list) {
            InternshipApiDto internshipApiDto = InternshipMapper.entityToApiDto(convocatory);
            listInternship.add(internshipApiDto);
        }
        return  listInternship;
    }

    @Override
    public void internShipChangeAprovedState(Integer id, Integer state) {
        Internship internship = internshipRepository.findById(id).orElseThrow();
        internship.setIsApproved(state);
        internshipRepository.save(internship);
        LOGGER.info("data {}", internship);
    }
}
