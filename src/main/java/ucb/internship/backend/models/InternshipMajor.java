package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name = "internship_major")
@Table(name = "internship_major")
public class InternshipMajor {

    @Id
    @Column(name = "internship_major_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internshipMajorId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "internship_id")
    @JsonIgnore
    private Internship internship;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    private Boolean status;

    public InternshipMajor(Internship internship, Major major, Boolean status) {
        this.internship = internship;
        this.major = major;
        this.status = status;
    }

    public InternshipMajor() {
    }

    public Integer getInternshipMajorId() {
        return internshipMajorId;
    }

    public void setInternshipMajorId(Integer internshipMajorId) {
        this.internshipMajorId = internshipMajorId;
    }
    @JsonIgnore
    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InternshipMajor{" +
                "internshipMajorId=" + internshipMajorId +
                ", major=" + major +
                ", status=" + status +
                '}';
    }
}
