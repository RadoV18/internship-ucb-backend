package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.InternshipDto;
import ucb.internship.backend.dtos.InternshipListDto;
import ucb.internship.backend.mappers.InternshipListMapper;
import ucb.internship.backend.models.Internship;
import ucb.internship.backend.models.InternshipMajor;
import ucb.internship.backend.repositories.InternshipRepository;
import ucb.internship.backend.services.InternshipService;
import java.sql.Timestamp;
import java.util.Collection;
import ucb.internship.backend.dtos.ActiveInternshipDto;
import ucb.internship.backend.dtos.ApplicantDto;
import ucb.internship.backend.dtos.ApplicantSummaryDto;
import ucb.internship.backend.models.City;
import ucb.internship.backend.repositories.CityRepository;
import ucb.internship.backend.repositories.InternshipApplicationRepository;
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

    public String createInternship(InternshipDto internshipDto) {
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
                benefit.setStatus(true);
                return benefit;
            }).toList());

            newInternship.setInternshipRequirements(internshipDto.getInternshipRequirements().stream().map(requirement -> {
                requirement.setInternship(newInternship);
                requirement.setStatus(true);
                return requirement;
            }).toList());
            newInternship.setInternshipRoles(internshipDto.getInternshipRoles().stream().map(role -> {
                role.setInternship(newInternship);
                role.setStatus(true);
                return role;
            }).toList());
            newInternship.setMajorList(internshipDto.getMajorList().stream().map(
                    major -> new InternshipMajor(newInternship, major, true)).toList());
            LOGGER.info("Internship {}", newInternship);
            internshipRepository.save(newInternship);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating internship";
        }
        return "Internship created successfully";
    }
    @Override
    public Page<InternshipListDto> filterInternships(String city , Timestamp startingDate, Timestamp endingDate, String major, Integer page, Integer size) {
        if(city == null || city.isEmpty())
            city = "%";
        else
            city = "%"+city+"%";
        if(startingDate == null)
            startingDate = Timestamp.valueOf("2019-11-1 00:00:00");
        if(endingDate == null)
            endingDate = new Timestamp(System.currentTimeMillis());
        if(major == null || major.isEmpty())
            major = "%";
        else
            major = "%"+major+"%";
        if(page == null)
            page = 0;
        if(size == null)
            size = 10;
        Page<Object[]> objectList= internshipRepository.findInternshipList(city,startingDate,endingDate,major,PageRequest.of(page,size));
        return objectList.map(InternshipListMapper::objectToDto);

    }
    @Override
    public List<ApplicantDto> getApplicantsByInternshipId(Integer id) {
        return internshipApplicationRepository.getApplicantsByInternshipId(id);
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

    public List<Internship> getInternshipById(Integer id){
     return  internshipRepository.findByInternshipId(id);
    }
}
