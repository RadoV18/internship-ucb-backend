package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "internship_benefits")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipBenefit {
    @Id
    @Column(name = "internship_benefits_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipBenefitId;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "internship_id")

    @ToString.Exclude
    private Internship internship;

    private String description;

    private Boolean status;
}



