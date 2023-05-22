package ucb.internship.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "internship_application_questions")
public class InternshipApplicationQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "internship_application_questions_id")
    private Long internshipApplicationQuestionId;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    @ToString.Exclude
    private Internship internship;

    @ManyToOne
    @JoinColumn(name = "internship_question_id")
    @ToString.Exclude
    private InternshipQuestion internshipQuestion;

    @ManyToOne
    @JoinColumn(name = "internship_application_id")
    @ToString.Exclude
    private InternshipApplication internshipApplication;

    private String response;

    private Boolean status;
}
