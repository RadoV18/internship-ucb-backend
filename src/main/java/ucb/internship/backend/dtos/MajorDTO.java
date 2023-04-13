package ucb.internship.backend.dtos;

public class MajorDTO {
    private Integer majorId;
    private String name;

    public MajorDTO(Integer majorId, String name) {
        this.majorId = majorId;
        this.name = name;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MajorDTO{" +
                "majorId=" + majorId +
                ", name='" + name + '\'' +
                '}';
    }
}
