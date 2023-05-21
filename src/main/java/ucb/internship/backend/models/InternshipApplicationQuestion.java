package ucb.internship.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "internship_application_question")
public class InternshipApplicationQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer internshipApplicationQuestionId;
    private Long internshipId;
    private Integer internshipQuestionId;
    private Long internshipApplicationId;
    private String response;
    private Boolean status = true;

    public InternshipApplicationQuestion(Long internshipId, Integer internshipQuestionId, Long internshipApplicationId,
            String response) {
        this.internshipId = internshipId;
        this.internshipQuestionId = internshipQuestionId;
        this.internshipApplicationId = internshipApplicationId;
        this.response = response;
    }

    public InternshipApplicationQuestion(Integer internshipApplicationQuestionId) {
        this.internshipApplicationQuestionId = internshipApplicationQuestionId;
    }

    public InternshipApplicationQuestion() {
    }

    public Integer getInternshipApplicationQuestionId() {
        return internshipApplicationQuestionId;
    }

    public void setInternshipApplicationQuestionId(Integer internshipApplicationQuestionId) {
        this.internshipApplicationQuestionId = internshipApplicationQuestionId;
    }

    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }

    public Integer getInternshipQuestionId() {
        return internshipQuestionId;
    }

    public void setInternshipQuestionId(Integer internshipQuestionId) {
        this.internshipQuestionId = internshipQuestionId;
    }

    public Long getInternshipApplicationId() {
        return internshipApplicationId;
    }

    public void setInternshipApplicationId(Long internshipApplicationId) {
        this.internshipApplicationId = internshipApplicationId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InternshipApplicationQuestion [internshipApplicationQuestionId=" + internshipApplicationQuestionId
                + ", internshipId=" + internshipId + ", internshipQuestionId=" + internshipQuestionId
                + ", internshipApplicationId=" + internshipApplicationId + ", response=" + response + ", status="
                + status + "]";
    }

}
