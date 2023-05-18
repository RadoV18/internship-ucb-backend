package ucb.internship.backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "internship_question")
public class InternshipQuestion {
    @Id
    @Column(name = "internship_questions_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internshipQuestionId;
    private String question;
    @ManyToOne(optional = false)
    @JoinColumn(name = "internship_id")
    @JsonIgnore
    private Internship internship;
    private Boolean status;
  
    public InternshipQuestion() {
    }

    public InternshipQuestion(Integer internshipQuestionId) {
        this.internshipQuestionId = internshipQuestionId;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @JsonIgnore
    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InternshipQuestion [internshipQuestionId=" + internshipQuestionId + ", question=" + question
                + ", internship=" + internship + ", status=" + status + "]";
    }
}
