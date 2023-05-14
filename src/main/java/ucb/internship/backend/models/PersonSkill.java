package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_skill")
public class PersonSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personSkillId;
    private Integer personId;
    private Integer skillId;
    private Boolean status = true;

    @JoinColumn(name = "skillId", referencedColumnName = "skillId", updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonManagedReference
    // @JsonBackReference
    private Skill skill;

    @JoinColumn(name = "personId", referencedColumnName = "personId", updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonManagedReference
    // @JsonBackReference
    private Person person;

    public PersonSkill() {
    }

    public PersonSkill(Integer personSkillId) {
        this.personSkillId = personSkillId;
    }

    public PersonSkill(Integer personId, Integer skillId) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "PersonSkill [personSkillId=" + personSkillId + ", personId=" + personId + ", skillId=" + skillId
                + ", status=" + status + ", skillHere=" + skill + "]";
    }
}
