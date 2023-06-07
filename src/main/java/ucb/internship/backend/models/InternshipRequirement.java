package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "internship_requirements")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipRequirement {
    @Id
    @Column(name = "internship_requirements_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requirementId;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    @JsonIgnore
    @ToString.Exclude
    private Internship internship;

    private String description;

    private Boolean status;
}
