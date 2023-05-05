package ucb.internship.backend.dtos;

public class MajorCustomDto {
    private Long campusMajorId;
    private String name;

    public MajorCustomDto(Long campusMajorId, String name) {
        this.campusMajorId = campusMajorId;
        this.name = name;
    }

    public Long getCampusMajorId() {
        return campusMajorId;
    }

    public void setCampusMajorId(Long campusMajorId) {
        this.campusMajorId = campusMajorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
