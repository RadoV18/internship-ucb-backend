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
    private Long majorId;
    private Boolean status = true;

    @JoinColumn(name = "campusId", referencedColumnName = "campusId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Campus campus;

    public CampusMajor(Long campusMajorId, Long majorId, Campus campus) {
        this.campusMajorId = campusMajorId;
        this.majorId = majorId;
        this.campus = campus;
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

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
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

    @Override
    public String toString() {
        return "CampusMajor [campusMajorId=" + campusMajorId + ", majorId=" + majorId + ", status=" + status
                + ", campus=" + campus + "]";
    }

}
