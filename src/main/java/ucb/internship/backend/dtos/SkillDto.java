package ucb.internship.backend.dtos;

public class SkillDto {
    private Integer skillId;
    private String name;
    private Boolean status;

    public SkillDto(Integer skillId, String name, Boolean status) {
        this.skillId = skillId;
        this.name = name;
        this.status = status;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SkillDto [skillId=" + skillId + ", name=" + name + ", status=" + status + "]";
    }
}
