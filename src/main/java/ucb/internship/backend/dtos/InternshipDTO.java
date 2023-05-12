package ucb.internship.backend.dtos;

import ucb.internship.backend.models.InternshipBenefit;
import ucb.internship.backend.models.InternshipRequirement;
import ucb.internship.backend.models.InternshipRole;
import ucb.internship.backend.models.Major;

import java.sql.Timestamp;
import java.util.List;

public class InternshipDTO {
    private Integer internshipId;
    private Long institutionId;
    private String title;
    private String description;

    private boolean isApproved;
    private Timestamp startingDate;
    private Timestamp endingDate;
    private List<InternshipBenefit> internshipBenefits;
    private List<InternshipRequirement> internshipRequirements;
    private List<InternshipRole> internshipRoles;
    private Integer cityId;
    private List<Major> majorList;

    public Integer getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Integer internshipId) {
        this.internshipId = internshipId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        this.isApproved = approved;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public List<Major> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<Major> majorList) {
        this.majorList = majorList;
    }

    public List<InternshipRole> getInternshipRoles() {
        return internshipRoles;
    }

    public void setInternshipRoles(List<InternshipRole> internshipRoles) {
        this.internshipRoles = internshipRoles;
    }

    @Override
    public String toString() {
        return "InternshipDto{" +
                "internshipId=" + internshipId +
                ", institutionId=" + institutionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isApproved=" + isApproved +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", internship_benefits=" + internshipBenefits +
                ", internship_requirements=" + internshipRequirements +
                ", internship_roles=" + internshipRoles +
                '}';
    }
}
