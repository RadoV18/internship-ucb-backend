package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.*;
import ucb.internship.backend.mappers.InternshipListMapper;
import ucb.internship.backend.mappers.InternshipMapper;
import ucb.internship.backend.models.*;
import ucb.internship.backend.repositories.*;
import ucb.internship.backend.services.InternshipService;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


@Service
public class InternshipServiceImpl implements InternshipService {
    private final InternshipRepository internshipRepository;
    private final InternshipApplicationRepository internshipApplicationRepository;
    private final CityRepository cityRepository;
    private final InstitutionRepository institutionRepository;
    private final MajorRepository majorRepository;
    public static final Logger LOGGER = LoggerFactory.getLogger(InternshipServiceImpl.class.getName());

    @Autowired
    public InternshipServiceImpl(
        InternshipRepository internshipRepository,
        InternshipApplicationRepository internshipApplicationRepository,
        CityRepository cityRepository,
        InstitutionRepository institutionRepository,
        MajorRepository majorRepository
    ) {
        this.internshipRepository = internshipRepository;
        this.internshipApplicationRepository = internshipApplicationRepository;
        this.cityRepository = cityRepository;
        this.institutionRepository = institutionRepository;
        this.majorRepository = majorRepository;
    }

    public String createInternship(InternshipDto internshipDto) {
        try {
            City city = cityRepository.findById(internshipDto.getCityId()).orElseThrow(() -> new RuntimeException("City not found"));
            Institution institution = institutionRepository.findById(internshipDto.getInstitutionId()).orElseThrow(() -> new RuntimeException("Institution not found"));
            Internship newInternship = new Internship();
            newInternship.setTitle(internshipDto.getTitle());
            newInternship.setDescription(internshipDto.getDescription());
            newInternship.setIsApproved(0);
            newInternship.setInstitution(institution);
            newInternship.setStatus(true);
            newInternship.setStartingDate(internshipDto.getStartingDate());
            newInternship.setEndingDate(internshipDto.getEndingDate());
            newInternship.setCity(city);
            newInternship.setInternshipBenefits(internshipDto.getInternshipBenefits().stream().map(benefit -> {
                InternshipBenefit newBenefit = new InternshipBenefit();
                newBenefit.setDescription(benefit.getDescription());
                newBenefit.setInternship(newInternship);
                newBenefit.setStatus(true);
                return newBenefit;
            }).toList());

            newInternship.setInternshipRequirements(internshipDto.getInternshipRequirements().stream().map(requirement -> {
                InternshipRequirement newRequirement = new InternshipRequirement();
                newRequirement.setDescription(requirement.getDescription());
                newRequirement.setInternship(newInternship);
                newRequirement.setStatus(true);
                return newRequirement;
            }).toList());
            newInternship.setInternshipRoles(internshipDto.getInternshipRoles().stream().map(role -> {
                InternshipRole newRole = new InternshipRole();
                newRole.setDescription(role.getDescription());
                newRole.setInternship(newInternship);
                newRole.setStatus(true);
                return newRole;
            }).toList());
            newInternship.setInternshipQuestions(internshipDto.getInternshipQuestions().stream().map(question -> {
                InternshipQuestion newQuestion = new InternshipQuestion();
                newQuestion.setDescription(question.getDescription());
                newQuestion.setInternship(newInternship);
                newQuestion.setStatus(true);
                return newQuestion;
            }).toList());
            newInternship.setMajorList(internshipDto.getMajorList().stream().map(
                major -> {
                    Major newMajor = majorRepository.findById(major.getMajorId()).orElseThrow(() -> new RuntimeException("Major not found"));
                    InternshipMajor newInternshipMajor = new InternshipMajor();
                    newInternshipMajor.setMajor(newMajor);
                    newInternshipMajor.setInternship(newInternship);
                    newInternshipMajor.setStatus(true);
                    return newInternshipMajor;
                }
            ).toList());
            LOGGER.info("Internship {}", newInternship);
            internshipRepository.save(newInternship);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error creating internship";
        }
        return "Internship created successfully";
    }
    @Override
    public Page<InternshipListDto> filterInternships(String city , Date startingDate, Date endingDate, String major, Integer page, Integer size) {
        Date startDate = null;
        Date endDate = null;
        if(city == null || city.isEmpty()) {
            city = "%";
        } else {
            city = "%" + city + "%";
        }
        if(startingDate == null) {
            startDate = Date.valueOf("1970-01-01");
        } else {
            startDate = startingDate;
        }
        if(endingDate == null) {
            endDate = Date.valueOf("2100-01-01");
        } else {
            endDate = endingDate;
        }
        if(major == null || major.isEmpty()) {
            major = "%";
        } else {
            major = "%" + major + "%";
        }
        if(page == null) {
            page = 0;
        }
        if(size == null) {
            size = 10;
        }
        LOGGER.info("city: {}, startDate: {}, endDate: {}, major: {}, page: {}, size: {}", city, startDate, endDate, major, page, size);
        Page<Internship> objectList = internshipRepository.findInternshipList(city, startDate, endDate, major, PageRequest.of(page,size));
        return objectList.map(InternshipListMapper::objectToDto);

    }
    @Override
    public List<ApplicantDto> getApplicantsByInternshipId(Long id) {
        return internshipApplicationRepository.getApplicantsByInternshipId(id);
    }
    @Override
    public List<ActiveInternshipDto> getActiveInternshipsByInstitutionId(Long id) {
        List<ActiveInternshipDto> result = new ArrayList<>();
        Institution institution = institutionRepository.findById(id).orElseThrow(() -> new RuntimeException("Institution not found"));
        List<Internship> internships = internshipRepository.findAllByInstitutionAndIsApprovedIs(institution, 1);
        for (Internship internship : internships) {
            Integer applicantCount = internshipApplicationRepository.countAllByInternship(internship);
            List<String> profilePictures = internshipApplicationRepository.getProfilePicturesByInternshipId(internship.getInternshipId());
            ApplicantSummaryDto applicationSummary = new ApplicantSummaryDto(applicantCount, profilePictures);
            City city = cityRepository.findByCityId(internship.getCity().getCityId());
            result.add(new ActiveInternshipDto(internship.getInternshipId(), internship.getTitle(),
                    internship.getStartingDate(), internship.getEndingDate(), city.getName(), applicationSummary));
        }
        return result;
    }

    public List<Internship> getInternshipById(Long id){
        return  internshipRepository.findByInternshipId(id);
    }

    @Override
    public InternshipApiDto getInternshipApiById(Long id){
        Internship internship = internshipRepository.findById(id).orElseThrow();
        return InternshipMapper.entityToApiDto(internship);
    }

    @Override
    public List<InternshipApiDto> getInternshipAll(){
        List<InternshipApiDto> listInternship = new ArrayList<>();
        List<Internship> list = internshipRepository.findByIsApproved(0);
        for (Internship pendingInternship : list) {
            InternshipApiDto internshipApiDto = InternshipMapper.entityToApiDto(pendingInternship);
            listInternship.add(internshipApiDto);
        }
        return listInternship;
    }

    @Override
    public void internShipChangeAprovedState(Long id, Integer state) {
        Internship internship = internshipRepository.findById(id).orElseThrow();
        internship.setIsApproved(state);
        internshipRepository.save(internship);
        LOGGER.info("data {}", internship);
    }

    @Override
    public InternshipDetailsDto getInternshipDetailsById(Long id) {
        Internship internship = internshipRepository.findById(id).orElseThrow();
        return InternshipMapper.entityToDetailsDto(internship);
    }
}
