package ucb.internship.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "major")
public class Major {
    @Id
    @Column(name = "major_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer majorId;
    private String name;
    private Integer status;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
