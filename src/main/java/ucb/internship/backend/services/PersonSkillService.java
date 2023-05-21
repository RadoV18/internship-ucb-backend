package ucb.internship.backend.services;

import java.util.List;

import ucb.internship.backend.dtos.PersonSkillDto;

public interface PersonSkillService {
    List<PersonSkillDto> getPersonSkills();

    List<PersonSkillDto> getPersonSkillByPersonId(Integer personId);

    PersonSkillDto postPersonSkill(PersonSkillDto personSkillDto);

    Integer deletePersonSkillById(Integer personSkillId);
}
