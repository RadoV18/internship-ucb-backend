package ucb.internship.backend.dtos;

import ucb.internship.backend.models.*;

import java.sql.Timestamp;
import java.util.List;

public class InternshipDto {
    private Long internshipId;
    private Long institutionId;
    private String title;
    private String description;

    private Integer isApproved;
    private Timestamp startingDate;
    private Timestamp endingDate;
    private List<InternshipBenefit> internshipBenefits;
    private List<InternshipRequirement> internshipRequirements;
    private List<InternshipRole> internshipRoles;
    private List<InternshipQuestion> internshipQuestions;
    private Long cityId;
    private List<Major> majorList;

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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
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

    public List<InternshipQuestion> getInternshipQuestions() {
        return internshipQuestions;
    }

    public void setInternshipQuestions(List<InternshipQuestion> internshipQuestions) {
        this.internshipQuestions = internshipQuestions;
    }

    @Override
    public String toString() {
        return "InternshipDTO{" +
                "internshipId=" + internshipId +
                ", institutionId=" + institutionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isApproved=" + isApproved +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", internshipBenefits=" + internshipBenefits +
                ", internshipRequirements=" + internshipRequirements +
                ", internshipRoles=" + internshipRoles +
                ", internshipQuestions=" + internshipQuestions +
                ", cityId=" + cityId +
                ", majorList=" + majorList +
                '}';
    }
}
