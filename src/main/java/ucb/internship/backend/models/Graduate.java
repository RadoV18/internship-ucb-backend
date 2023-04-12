package ucb.internship.backend.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "graduate")
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long graduateId;

    private Long personId;
    private Date graduationDate;
    private Long campusMajorId;
    private Boolean status = false;

    public Graduate(Long graduateId, Long personId, Date graduationDate, Long campusMajorId) {
        this.graduateId = graduateId;
        this.personId = personId;
        this.graduationDate = graduationDate;
        this.campusMajorId = campusMajorId;
    }

    public Graduate(Long graduateId) {
        this.graduateId = graduateId;
    }

    public Graduate() {
    }

    public Long getGraduateId() {
        return graduateId;
    }

    public void setGraduateId(Long graduateId) {
        this.graduateId = graduateId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Long getCampusMajorId() {
        return campusMajorId;
    }

    public void setCampusMajorId(Long campusMajorId) {
        this.campusMajorId = campusMajorId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Graduate [graduateId=" + graduateId + ", personId=" + personId + ", graduationDate=" + graduationDate
                + ", campusMajorId=" + campusMajorId + ", status=" + status + "]";
    }
}
