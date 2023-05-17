package ucb.internship.backend.dtos;

import java.util.List;

public class CampusDto {
    private Long campusId;
    private String name;
    private List<MajorCustomDto> majors;

    public CampusDto(Long campusId, String name, List<MajorCustomDto> majors) {
        this.campusId = campusId;
        this.name = name;
        this.majors = majors;
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MajorCustomDto> getMajors() {
        return majors;
    }

    public void setMajors(List<MajorCustomDto> majors) {
        this.majors = majors;
    }
}