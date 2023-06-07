package ucb.internship.backend.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.ToString;

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

    @OneToMany(mappedBy = "campusMajor")
    @ToString.Exclude
    private List<Student> students;

    @OneToMany(mappedBy = "campusMajor")
    @ToString.Exclude
    private List<Graduate> graduates;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Graduate> getGraduates() {
        return graduates;
    }

    public void setGraduates(List<Graduate> graduates) {
        this.graduates = graduates;
    }

    @Override
    public String toString() {
        return "CampusMajor [campusMajorId=" + campusMajorId + ", status=" + status + ", campus=" + campus + ", major="
                + major + "]";
    }
}
