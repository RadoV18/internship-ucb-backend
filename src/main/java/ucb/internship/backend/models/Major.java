package ucb.internship.backend.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "major")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Major {
    @Id
    @Column(name = "major_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long majorId;
    private String name;
    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "major", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CampusMajor> campusMajors;
}
