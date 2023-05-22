package ucb.internship.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "internship_application")
public class InternshipApplication {
    @Id
    @Column(name = "internship_application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipApplicationId;
    @Column(name = "submitted_on")
    private Date submittedOn;
    @Column(name = "admitted")
    private Integer admitted;
    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "internship_id", insertable = false, updatable = false)
    @ToString.Exclude
    private Internship internship;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    @ToString.Exclude
    private Person person;

    @OneToMany(mappedBy = "internshipApplication")
    private List<InternshipApplicationQuestion> internshipApplicationQuestions;
}
