package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.ActiveInternshipDto;
import ucb.internship.backend.dtos.ApplicantDto;
import ucb.internship.backend.dtos.ApplicantSummaryDto;
import ucb.internship.backend.dtos.InternshipDTO;
import ucb.internship.backend.models.City;
import ucb.internship.backend.models.Internship;
import ucb.internship.backend.models.InternshipMajor;
import ucb.internship.backend.repositories.CityRepository;
import ucb.internship.backend.repositories.InternshipApplicationRepository;
import ucb.internship.backend.repositories.InternshipRepository;
import ucb.internship.backend.services.InternshipService;

import java.util.ArrayList;
import java.util.List;


@Service
public class InternshipServiceImpl implements InternshipService {
    private final InternshipRepository internshipRepository;
    private final InternshipApplicationRepository internshipApplicationRepository;
    private final CityRepository cityRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(InternshipServiceImpl.class.getName());

    @Autowired
    public InternshipServiceImpl(InternshipRepository internshipRepository,
        InternshipApplicationRepository internshipApplicationRepository, CityRepository cityRepository
    ) {
        this.internshipRepository = internshipRepository;
        this.internshipApplicationRepository = internshipApplicationRepository;
        this.cityRepository = cityRepository;
    }

    public String createInternship(InternshipDTO internshipDto) {
        try {
            Internship newInternship = new Internship();
            newInternship.setTitle(internshipDto.getTitle());
            newInternship.setDescription(internshipDto.getDescription());
            newInternship.setIsApproved(0);
            newInternship.setInstitutionId(internshipDto.getInstitutionId());
            newInternship.setStatus(true);
            newInternship.setStartingDate(internshipDto.getStartingDate());
            newInternship.setEndingDate(internshipDto.getEndingDate());
            newInternship.setCityId(internshipDto.getCityId());
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
    public List<Internship> getInternshipById(Integer id){
     return  internshipRepository.findByInternshipId(id);
    }

    @Override
    public List<ActiveInternshipDto> getActiveInternshipsByInstitutionId(Integer id) {
        List<ActiveInternshipDto> result = new ArrayList<>();
        List<Internship> internships = internshipRepository.findAllByInstitutionIdAndIsApprovedIs(id, 1);
        for (Internship internship : internships) {
            Integer applicantCount = internshipApplicationRepository.countAllByInternshipId(internship.getInternshipId());
            List<String> profilePictures = internshipApplicationRepository.getProfilePicturesByInternshipId(internship.getInternshipId());
            ApplicantSummaryDto applicationSummary = new ApplicantSummaryDto(applicantCount, profilePictures);
            City city = cityRepository.findByCityId(internship.getCityId());
            result.add(new ActiveInternshipDto(internship.getInternshipId(), internship.getTitle(),
                internship.getStartingDate(), internship.getEndingDate(), city.getName(), applicationSummary));
        }
        return result;
    }

    @Override
    public List<ApplicantDto> getApplicantsByInternshipId(Integer id) {
        return internshipApplicationRepository.getApplicantsByInternshipId(id);
    }
}
