package ucb.internship.backend.dtos;

public class CampusMajorDto {
    private Long campusMajorId;
    private String campus;
    private String major;

    public CampusMajorDto(Long campusMajorId, String campus, String major) {
        this.campusMajorId = campusMajorId;
        this.campus = campus;
        this.major = major;
    }

    public Long getCampusMajorId() {
        return campusMajorId;
    }

    public void setCampusMajorId(Long campusMajorId) {
        this.campusMajorId = campusMajorId;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "CampusMajorDto [campusMajorId=" + campusMajorId + ", campus=" + campus + ", major=" + major + "]";
    }
}
