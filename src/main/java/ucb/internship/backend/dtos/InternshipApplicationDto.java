package ucb.internship.backend.dtos;

import java.util.Date;
import java.util.List;

public class InternshipApplicationDto {
    private Long internshipApplicationId;
    private Long internshipId;
    private Long personId;
    private Date submittedOn;
    private Integer admitted;
    private Boolean status;
    private List<InternshipApplicationQuestionDto> internshipApplicationQuestionDtos;

    public InternshipApplicationDto(Long internshipApplicationId, Long internshipId, Long personId, Date submittedOn,
            Integer admitted, Boolean status,
            List<InternshipApplicationQuestionDto> internshipApplicationQuestionDtos) {
        this.internshipApplicationId = internshipApplicationId;
        this.internshipId = internshipId;
        this.personId = personId;
        this.submittedOn = submittedOn;
        this.admitted = admitted;
        this.status = status;
        this.internshipApplicationQuestionDtos = internshipApplicationQuestionDtos;
    }

    public Long getInternshipApplicationId() {
        return internshipApplicationId;
    }

    public void setInternshipApplicationId(Long internshipApplicationId) {
        this.internshipApplicationId = internshipApplicationId;
    }

    public Long getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(Long internshipId) {
        this.internshipId = internshipId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Integer getAdmitted() {
        return admitted;
    }

    public void setAdmitted(Integer admitted) {
        this.admitted = admitted;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<InternshipApplicationQuestionDto> getInternshipApplicationQuestionDtos() {
        return internshipApplicationQuestionDtos;
    }

    public void setInternshipApplicationQuestionDtos(
            List<InternshipApplicationQuestionDto> internshipApplicationQuestionDtos) {
        this.internshipApplicationQuestionDtos = internshipApplicationQuestionDtos;
    }

    @Override
    public String toString() {
        return "InternshipApplicationDto [internshipApplicationId=" + internshipApplicationId + ", internshipId="
                + internshipId + ", personId=" + personId + ", submittedOn=" + submittedOn + ", admitted=" + admitted
                + ", status=" + status + ", internshipApplicationQuestionDtos=" + internshipApplicationQuestionDtos
                + "]";
    }
}
