package ucb.internship.backend.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "internship")
public class Internship {
    @Id
    @Column(name = "internship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipId;
    @Column(name = "institution_id")
    private Integer institutionId;
    @Column(name = "city_id")
    private Integer cityId;
    private String title;
    private String description;
    @Column(name = "is_approved")
    private Integer isApproved;
    @Column(name = "starting_date")
    private Timestamp startingDate;
    @Column(name = "ending_date")
    private Timestamp endingDate;
    private Boolean status;

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

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
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
