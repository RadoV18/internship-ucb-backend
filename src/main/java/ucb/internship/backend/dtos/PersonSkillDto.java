package ucb.internship.backend.dtos;

public class PersonSkillDto {
    private Integer personSkillId;
    private Integer personId;
    private Integer skillId;

    public PersonSkillDto(Integer personSkillId, Integer personId, Integer skillId) {
        this.personSkillId = personSkillId;
        this.personId = personId;
        this.skillId = skillId;
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

    @Override
    public String toString() {
        return "PersonSkillDto [personSkillId=" + personSkillId + ", personId=" + personId + ", skillId=" + skillId
                + "]";
    }
}
