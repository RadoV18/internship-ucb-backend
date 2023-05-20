package ucb.internship.backend.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "major")
public class Major {
    @Id
    @Column(name = "major_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer majorId;
    private String name;
    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "major", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CampusMajor> campusMajors;

    public Major() {
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId=" + majorId +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
