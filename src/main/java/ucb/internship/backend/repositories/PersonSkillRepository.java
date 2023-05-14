package ucb.internship.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.PersonSkill;

@Repository
public interface PersonSkillRepository extends JpaRepository<PersonSkill, Integer> {
    List<PersonSkill> findByPersonId(Integer personId);
}
