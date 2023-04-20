package ucb.internship.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "internship_benefits")
public class InternshipBenefit {
    @Id
    @Column(name = "internship_benefits_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BenefitId;
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "internship_id")

    private Internship internship;
    private String description;
    private boolean status;

    public Integer getBenefitId() {
        return BenefitId;
    }

    public void setBenefitId(Integer internshipBenefitId) {
        this.BenefitId = internshipBenefitId;
    }

    public InternshipBenefit() {
    }

    @JsonIgnore
    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InternshipBenefit{" +
                "internshipBenefitId=" + BenefitId +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}



