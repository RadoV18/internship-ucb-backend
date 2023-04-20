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
    private boolean status;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
