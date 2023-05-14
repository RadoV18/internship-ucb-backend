package ucb.internship.backend.dtos;

public class InternshipApplicationQuestionDto {
    private Integer internshipApplicationQuestionId;
    private Long internshipId;
    private Integer internshipQuestionId;
    private Long internshipApplicationId;
    private String response;
    private Boolean status;

    public InternshipApplicationQuestionDto(Integer internshipApplicationQuestionId, Long internshipId,
            Integer internshipQuestionId, Long internshipApplicationId, String response, Boolean status) {
        this.internshipApplicationQuestionId = internshipApplicationQuestionId;
        this.internshipId = internshipId;
        this.internshipQuestionId = internshipQuestionId;
        this.internshipApplicationId = internshipApplicationId;
        this.response = response;
        this.status = status;
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
        return "InternshipApplicationQuestionDto [internshipApplicationQuestionId=" + internshipApplicationQuestionId
                + ", internshipId=" + internshipId + ", internshipQuestionId=" + internshipQuestionId
                + ", internshipApplicationId=" + internshipApplicationId + ", response=" + response + ", status="
                + status + "]";
    }

}
