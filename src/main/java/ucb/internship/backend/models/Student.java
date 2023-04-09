package ucb.internship.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private Long personId;
    private Long campusMajorId;
    private Integer semester;
    private Boolean status = false;

    public Student(Long studentId, Long personId, Long campusMajorId, Integer semester) {
        this.studentId = studentId;
        this.personId = personId;
        this.campusMajorId = campusMajorId;
        this.semester = semester;
    }

    public Student(Long studentId) {
        this.studentId = studentId;
    }

    public Student() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getCampusMajorId() {
        return campusMajorId;
    }

    public void setCampusMajorId(Long campusMajorId) {
        this.campusMajorId = campusMajorId;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", personId=" + personId + ", campusMajorId=" + campusMajorId
                + ", semester=" + semester + ", status=" + status + "]";
    }
}
