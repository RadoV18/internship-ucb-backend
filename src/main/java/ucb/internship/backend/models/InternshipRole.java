package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "internship_roles")
public class InternshipRole {
    @Id
    @Column(name = "internship_roles_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internshipRoleId;
    @ManyToOne
    @JoinColumn(name = "internship_id")
    @JsonIgnore
    private Internship internship;
    private String description;
    private Integer status;

    public InternshipRole() {
    }

    public Integer getInternshipRoleId() {
        return internshipRoleId;
    }
    public void setInternshipRoleId(Integer internship_role_id) {
        this.internshipRoleId = internship_role_id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String role) {
        this.description = role;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }
    @JsonIgnore
    public Internship getInternship() {
        return internship;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InternshipRole{" +
                "internshipRoleId=" + internshipRoleId +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
