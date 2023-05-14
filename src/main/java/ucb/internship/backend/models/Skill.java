package ucb.internship.backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillId;
    private String name;
    private Boolean status = true;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill", fetch = FetchType.EAGER)
    @JsonBackReference
    // @JsonManagedReference
    private List<PersonSkill> personSkills;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "skill", fetch = FetchType.EAGER)
    // @JsonBackReference
    @JsonManagedReference
    private List<SkillCategory> skillCategories;

    public Skill() {
    }

    public Skill(Integer skillId) {
        this.skillId = skillId;
    }

    public Skill(Integer skillId, String name) {
        this.skillId = skillId;
        this.name = name;
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

    public List<PersonSkill> getPersonSkills() {
        return personSkills;
    }

    public void setPersonSkills(List<PersonSkill> personSkills) {
        this.personSkills = personSkills;
    }

    @Override
    public String toString() {
        return "Skill [skillId=" + skillId + ", name=" + name + ", status=" + status + ", personSkills=" + personSkills
                + "]";
    }
}
