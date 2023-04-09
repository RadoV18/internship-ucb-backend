package ucb.internship.backend.dtos;

public class StudentDto {
    private Long studentId;
    private PersonDto personDto;
    private Long campusMajorId;
    private Integer semester;
    private Boolean status;

    public StudentDto() {
    }

    public StudentDto(Long studentId, PersonDto personDto, Long campusMajorId, Integer semester, Boolean status) {
        this.studentId = studentId;
        this.personDto = personDto;
        this.campusMajorId = campusMajorId;
        this.semester = semester;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public Long getCampusMajorId() {
        return campusMajorId;
    }

    public void setCampusMajorId(Long campusMajorId) {
        this.campusMajorId = campusMajorId;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentDto [studentId=" + studentId + ", personDto=" + personDto + ", campusMajorId=" + campusMajorId
                + ", semester=" + semester + ", status=" + status + "]";
    }
}
