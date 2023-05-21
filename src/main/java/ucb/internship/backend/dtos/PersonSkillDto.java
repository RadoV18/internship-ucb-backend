package ucb.internship.backend.dtos;

public class PersonSkillDto {
    private Integer personSkillId;
    private Integer personId;
    private Integer skillId;
    private SkillDto skill;

    public PersonSkillDto() {
    }

    public PersonSkillDto(Integer personSkillId, Integer personId, Integer skillId, SkillDto skill) {
        this.personSkillId = personSkillId;
        this.personId = personId;
        this.skillId = skillId;
        this.skill = skill;
    }

    public Integer getPersonSkillId() {
        return personSkillId;
    }

    public void setPersonSkillId(Integer personSkillId) {
        this.personSkillId = personSkillId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "PersonSkillDto [personSkillId=" + personSkillId + ", personId=" + personId + ", skillId=" + skillId
                + ", skill=" + skill + "]";
    }
}
