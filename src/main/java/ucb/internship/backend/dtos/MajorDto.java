package ucb.internship.backend.dtos;

public class MajorDto {
    private Integer majorId;
    private String name;

    public MajorDto() {}

    public MajorDto(Integer majorId, String name) {
        this.majorId = majorId;
        this.name = name;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer id) {
        this.majorId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MajorDto{" +
                "id=" + majorId +
                ", name='" + name + '\'' +
                '}';
    }
}
