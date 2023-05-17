package ucb.internship.backend.dtos;

import java.sql.Date;

public class ApplicantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String major;
    private String email;
    private Date submittedOn;
    private Integer status;
    private String cvUrl;
    private String profilePictureUrl;

    public ApplicantDto() {
    }

    public ApplicantDto(Long id, String firstName, String lastName, String major, String email, Date submittedOn, Integer status, String cvUrl, String profilePictureUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.email = email;
        this.submittedOn = submittedOn;
        this.status = status;
        this.cvUrl = cvUrl;
        this.profilePictureUrl = profilePictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCvUrl() {
        return cvUrl;
    }

    public void setCvUrl(String cvUrl) {
        this.cvUrl = cvUrl;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    @Override
    public String toString() {
        return "ApplicantDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                ", email='" + email + '\'' +
                ", submittedOn=" + submittedOn +
                ", status=" + status +
                ", cvUrl='" + cvUrl + '\'' +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                '}';
    }
}
