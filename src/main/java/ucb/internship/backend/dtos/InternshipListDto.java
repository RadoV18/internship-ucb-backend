package ucb.internship.backend.dtos;

import java.sql.Timestamp;

public class InternshipListDto {
    private Integer internshipId;
    private String title;
    private String description;
    private Timestamp startingDate;
    private Timestamp endingDate;
    private String city;
    private String institution;
    private String url;



    public InternshipListDto(Integer internshipId, String title, String description, Timestamp startingDate, Timestamp endingDate, String institutionName, String url, String city) {
        this.internshipId = internshipId;
        this.title = title;
        this.description = description;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.institution = institutionName;
        this.url = url;
        this.city = city;
    }

    public InternshipListDto() {

    }

    public Integer getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Integer institutionId) {
        this.internshipId = institutionId;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String insititutionName) {
        this.institution = insititutionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
