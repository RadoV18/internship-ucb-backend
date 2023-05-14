package ucb.internship.backend.dtos;

import java.sql.Timestamp;
import java.util.List;

public class InternshipApiDto {
    private Long internshipId;
    private String institutionId;
    private String title;
    private String description;
    private String city;
    private Integer isApproved;
    private String startingDate;
    private String endingDate;
    private List<String> internshipBenefits;
    private List<String> internshipRequirements;
    private List<String> internshipRoles;
    private List<String> majorList;

    public Long getInternshipId() {
        return internshipId;
    }
    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }
    public String getInstitutionId() {
        return institutionId;
    }
    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
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
    public Integer isApproved() {
        return isApproved;
    }
    public void setApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }
    public String getStartingDate() {
        return startingDate;
    }
    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }
    public String getEndingDate() {
        return endingDate;
    }
    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }
    public List<String> getInternshipBenefits() {
        return internshipBenefits;
    }
    public void setInternshipBenefits(List<String> internshipBenefits) {
        this.internshipBenefits = internshipBenefits;
    }
    public List<String> getInternshipRequirements() {
        return internshipRequirements;
    }
    public void setInternshipRequirements(List<String> internshipRequirements) {
        this.internshipRequirements = internshipRequirements;
    }
    public List<String> getInternshipRoles() {
        return internshipRoles;
    }
    public void setInternshipRoles(List<String> internshipRoles) {
        this.internshipRoles = internshipRoles;
    }
    public String getCity() {
        return city;
    }
    public void setCityId(String city) {
        this.city = city;
    }
    public List<String> getMajorList() {
        return majorList;
    }
    public void setMajorList(List<String> majorList) {
        this.majorList = majorList;
    }
    
    @Override
    public String toString() {
        return "InternshipApiDto [internshipId=" + internshipId + ", institutionId=" + institutionId + ", title="
                + title + ", description=" + description + ", isApproved=" + isApproved + ", startingDate="
                + startingDate + ", endingDate=" + endingDate + ", internshipBenefits=" + internshipBenefits
                + ", internshipRequirements=" + internshipRequirements + ", internshipRoles=" + internshipRoles
                + ", cityId=" + city + ", majorList=" + majorList + "]";
    }

    

    
    
}
