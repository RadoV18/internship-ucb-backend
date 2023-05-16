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

    public InternshipApiDto getInternshipApiById(Integer id){
        Internship gInternship = internshipRepository.findById(id).orElseThrow();
        InternshipApiDto newInternshipApiDto = InternshipMapper.entityToApiDto(gInternship);
        return  newInternshipApiDto;
    }

    public List<InternshipApiDto> getInternshipAll(){
        List<InternshipApiDto> listInternship = new ArrayList<>();
        LOGGER.info("Los datos de la convocatoria es {}", internshipRepository.findAll());
        List<Internship> list = internshipRepository.findAll();
        for (Internship convocatory : list) {
            InternshipApiDto internshipApiDto = InternshipMapper.entityToApiDto(convocatory);
            listInternship.add(internshipApiDto);
        }
        return  listInternship;
    }
}


package ucb.internship.backend.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "internship")
public class Internship {
    @Id
    @Column(name = "internship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipId;

    @Column(name = "institution_id")
    private Long institutionId;

    @Column(name = "city_id")
    private Long cityId;

    private String title;

    private String description;

    @Column(name = "is_approved")
    private Integer isApproved;

    @Column(name = "starting_date")
    private Timestamp startingDate;

    @Column(name = "ending_date")
    private Timestamp endingDate;

    private Boolean status;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipBenefit> internshipBenefits;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true, mappedBy = "internship")
    private List<InternshipRequirement> internshipRequirements;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipRole> internshipRoles;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipQuestion> internshipQuestions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipMajor> majorList;


    public Internship() {
    }
    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }

    public Timestamp getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Timestamp startingDate) {
        this.startingDate = startingDate;
    }

    public Timestamp getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Timestamp endingDate) {
        this.endingDate = endingDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<InternshipBenefit> getInternshipBenefits() {
        return internshipBenefits;
    }

    public void setInternshipBenefits(List<InternshipBenefit> internshipBenefits) {
        this.internshipBenefits = internshipBenefits;
    }

    public List<InternshipRequirement> getInternshipRequirements() {
        return internshipRequirements;
    }

    public void setInternshipRequirements(List<InternshipRequirement> internshipRequirements) {
        this.internshipRequirements = internshipRequirements;
    }

    public List<InternshipRole> getInternshipRoles() {
        return internshipRoles;
    }

    public void setInternshipRoles(List<InternshipRole> internshipRoles) {
        this.internshipRoles = internshipRoles;
    }

    public List<InternshipQuestion> getInternshipQuestions() {
        return internshipQuestions;
    }

    public void setInternshipQuestions(List<InternshipQuestion> internshipQuestions) {
        this.internshipQuestions = internshipQuestions;
    }

    public List<InternshipMajor> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<InternshipMajor> majorList) {
        this.majorList = majorList;
    }

    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Internship{" +
                "internshipId=" + internshipId +
                ", institutionId=" + institutionId +
                ", cityId=" + cityId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isApproved=" + isApproved +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", status=" + status +
                ", internshipBenefits=" + internshipBenefits +
                ", internshipRequirements=" + internshipRequirements +
                ", internshipRoles=" + internshipRoles +
                ", internshipQuestions=" + internshipQuestions +
                ", majorList=" + majorList +
                '}';
    }
}
