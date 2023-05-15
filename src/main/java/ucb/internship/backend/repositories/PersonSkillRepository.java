package ucb.internship.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import ucb.internship.backend.models.PersonSkill;

@Repository
public interface PersonSkillRepository extends JpaRepository<PersonSkill, Integer> {
    List<PersonSkill> findByPersonId(Integer personId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM person_skill AS ps WHERE ps.person_skill_id=:personSkillId", nativeQuery = true)
    Integer deletePersonSkillByPersonSkillId(Integer personSkillId);
}
