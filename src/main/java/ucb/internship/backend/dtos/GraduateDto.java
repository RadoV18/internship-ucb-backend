package ucb.internship.backend.dtos;

import java.util.Date;

public class GraduateDto {
    private Long graduateId;
    private PersonDto personDto;
    private Date graduationDate;
    private Long campusMajorId;
    private Boolean status;

    public GraduateDto(Long graduateId, PersonDto personDto, Date graduationDate, Long campusMajorId, Boolean status) {
        this.graduateId = graduateId;
        this.personDto = personDto;
        this.graduationDate = graduationDate;
        this.campusMajorId = campusMajorId;
        this.status = status;
    }

    public Long getGraduateId() {
        return graduateId;
    }

    public void setGraduateId(Long graduateId) {
        this.graduateId = graduateId;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Long getCampusMajorId() {
        return campusMajorId;
    }

    public void setCampusMajorId(Long campusMajorId) {
        this.campusMajorId = campusMajorId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GraduateDto [graduateId=" + graduateId + ", personDto=" + personDto + ", graduationDate="
                + graduationDate + ", campusMajorId=" + campusMajorId + ", status=" + status + "]";
    }
}
