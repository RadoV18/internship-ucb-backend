package ucb.internship.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "campus_major")
public class CampusMajor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campusMajorId;
    private Boolean status = true;

    @JoinColumn(name = "campusId", referencedColumnName = "campusId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Campus campus;

    @JoinColumn(name = "majorId", referencedColumnName = "major_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Major major;

    public CampusMajor(Long campusMajorId, Campus campus, Major major) {
        this.campusMajorId = campusMajorId;
        this.campus = campus;
        this.major = major;
    }

    public CampusMajor(Long campusMajorId) {
        this.campusMajorId = campusMajorId;
    }

    public CampusMajor() {
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

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "CampusMajor [campusMajorId=" + campusMajorId + ", status=" + status + ", campus=" + campus + ", major="
                + major + "]";
    }
}
