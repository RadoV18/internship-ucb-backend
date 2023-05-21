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
@Table(name = "skill_category")
public class SkillCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillCategoryId;
    private Integer skillId;
    private Integer categoryId;
    private Boolean status = true;

    @JoinColumn(name = "skillId", referencedColumnName = "skillId", updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    // @JsonManagedReference
    @JsonBackReference
    private Skill skill;

    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", updatable = false, insertable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JsonManagedReference
    // @JsonBackReference
    private Category category;

    public SkillCategory() {
    }

    public SkillCategory(Integer skillId) {
        this.skillId = skillId;
    }

    public SkillCategory(Integer skillId, Integer categoryId) {
        this.skillId = skillId;
        this.categoryId = categoryId;
    }

    public Integer getSkillCategoryId() {
        return skillCategoryId;
    }

    public void setSkillCategoryId(Integer skillCategoryId) {
        this.skillCategoryId = skillCategoryId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SkillCategory [skillCategoryId=" + skillCategoryId + ", skillId=" + skillId + ", categoryId="
                + categoryId + ", status=" + status + ", skill=" + skill + ", category=" + category + "]";
    }
}
