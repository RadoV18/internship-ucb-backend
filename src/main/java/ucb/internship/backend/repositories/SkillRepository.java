package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
