package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "internship_requirements")
public class InternshipRequirement {
    @Id
    @Column(name = "internship_requirements_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requirementId;
    @ManyToOne
    @JoinColumn(name = "internship_id")
    @JsonIgnore
    private Internship internship;
    private String description;
    private boolean status;

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirement_id) {
        this.requirementId = requirement_id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String requirement) {
        this.description = requirement;
    }
    @JsonIgnore
    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public InternshipRequirement() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InternshipRequirement{" +
                "requirementId=" + requirementId +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
