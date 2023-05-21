package ucb.internship.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "internship_question")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipQuestion {
    @Id
    @Column(name = "internship_questions_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipQuestionId;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    @ToString.Exclude
    private Internship internship;

    private String description;

    private Boolean status;
}
