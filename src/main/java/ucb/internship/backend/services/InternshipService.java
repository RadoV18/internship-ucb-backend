package ucb.internship.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.InternshipDTO;
import ucb.internship.backend.models.Internship;
import ucb.internship.backend.models.InternshipMajor;
import ucb.internship.backend.repositories.InternshipRepository;

import java.util.List;


@Service
public class InternshipService {
    private final InternshipRepository internshipRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(InternshipService.class.getName());
    @Autowired
    public InternshipService(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    public String createInternship(InternshipDTO internshipDto) {
        try {
            Internship newInternship = new Internship();
            newInternship.setTitle(internshipDto.getTitle());
            newInternship.setDescription(internshipDto.getDescription());
            newInternship.setIsApproved(0);
            newInternship.setInstitutionId(internshipDto.getInstitutionId());
            newInternship.setStatus(1);
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
}