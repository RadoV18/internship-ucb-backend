package ucb.internship.backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "internship")
public class Internship {
    @Id
    @Column(name = "internship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipId;

    private String title;
    private String description;
    @Column(name = "is_approved")
    private Integer isApproved;

    @Column(name = "starting_date")
    private Timestamp startingDate;

    @Column(name = "ending_date")
    private Timestamp endingDate;

    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipBenefit> internshipBenefits;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipRequirement> internshipRequirements;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipRole> internshipRoles;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipQuestion> internshipQuestions;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipMajor> majorList;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "institution_id")
    private Institution institution;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "city_id")
    private City city;
  
    public Internship() {
    }
  
    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
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
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Internship{" +
                "internshipId=" + internshipId +
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

    public List<InternshipQuestion> getInternshipQuestions() {
        return internshipQuestions;
    }

    public void setInternshipQuestions(List<InternshipQuestion> internshipQuestions) {
        this.internshipQuestions = internshipQuestions;
    }
}
