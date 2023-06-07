package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "internship_roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipRole {
    @Id
    @Column(name = "internship_roles_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipRoleId;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    @JsonIgnore
    @ToString.Exclude
    private Internship internship;

    private String description;

    private Boolean status;
}
