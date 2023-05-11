package ucb.internship.backend.models;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "internship_application")
public class InternshipApplication {
    @Id
    @Column(name = "internship_application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipApplicationId;
    @Column(name = "internship_id")
    private Long internshipId;
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "submitted_on")
    private Date submittedOn;
    @Column(name = "admitted")
    private Integer admitted;
    @Column(name = "status")
    private Boolean status;

    public InternshipApplication() {
    }

    public Long getInternshipApplicationId() {
        return internshipApplicationId;
    }

    public void setInternshipApplicationId(Long internshipApplicationId) {
        this.internshipApplicationId = internshipApplicationId;
    }

    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Integer getAdmitted() {
        return admitted;
    }

    public void setAdmitted(Integer admitted) {
        this.admitted = admitted;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InternshipApplication{" +
                "internshipApplicationId=" + internshipApplicationId +
                ", internshipId=" + internshipId +
                ", personId=" + personId +
                ", submittedOn=" + submittedOn +
                ", admitted=" + admitted +
                ", status=" + status +
                '}';
    }
}
