package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "internship_major")
@Table(name = "internship_major")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipMajor {

    @Id
    @Column(name = "internship_major_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipMajorId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "internship_id")
    @JsonIgnore
    @ToString.Exclude
    private Internship internship;

    @ManyToOne
    @JoinColumn(name = "major_id")
    @ToString.Exclude
    private Major major;

    private Boolean status;
}
