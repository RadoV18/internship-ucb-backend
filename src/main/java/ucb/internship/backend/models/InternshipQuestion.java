package ucb.internship.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "internship_question")
public class InternshipQuestion {
    @Id
    @Column(name = "internship_questions_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internshipQuestionId;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    private Internship internship;

    private String question;
    private Boolean status;

    public InternshipQuestion() {
    }

    public InternshipQuestion(Integer internshipQuestionId, Internship internship, String question, Boolean status) {
        this.internshipQuestionId = internshipQuestionId;
        this.internship = internship;
        this.question = question;
        this.status = status;
    }

    public Integer getInternshipQuestionId() {
        return internshipQuestionId;
    }

    public void setInternshipQuestionId(Integer internshipQuestionId) {
        this.internshipQuestionId = internshipQuestionId;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InternshipQuestion{" +
                "internshipQuestionId=" + internshipQuestionId +
                ", question='" + question + '\'' +
                ", status=" + status +
                '}';
    }
}
