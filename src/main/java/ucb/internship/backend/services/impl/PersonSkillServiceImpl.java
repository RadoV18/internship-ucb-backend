package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.dtos.PersonSkillDto;
import ucb.internship.backend.dtos.SkillDto;
import ucb.internship.backend.models.PersonSkill;
import ucb.internship.backend.repositories.PersonSkillRepository;
import ucb.internship.backend.services.PersonSkillService;

@Service
public class PersonSkillServiceImpl implements PersonSkillService {
    @Autowired
    private PersonSkillRepository personSkillRepository;

    public List<PersonSkillDto> getPersonSkills() {
        List<PersonSkillDto> personSkillDtos = new ArrayList<>();
        List<PersonSkill> personSkills = personSkillRepository.findAll();
        personSkills.forEach((personSkill) -> {
            personSkillDtos.add(
                    new PersonSkillDto(personSkill.getPersonSkillId(), personSkill.getPersonId(),
                            personSkill.getSkillId(),
                            new SkillDto(personSkill.getSkill().getSkillId(), personSkill.getSkill().getName(),
                                    personSkill.getSkill().getStatus())));
        });
        return personSkillDtos;
    }

    public List<PersonSkillDto> getPersonSkillByPersonId(Integer personId) {
        List<PersonSkillDto> personSkillDtos = new ArrayList<>();
        List<PersonSkill> personSkills = personSkillRepository.findByPersonId(personId);
        personSkills.forEach((personSkill) -> {
            personSkillDtos.add(
                    new PersonSkillDto(personSkill.getPersonSkillId(), personSkill.getPersonId(),
                            personSkill.getSkillId(),
                            new SkillDto(personSkill.getSkill().getSkillId(), personSkill.getSkill().getName(),
                                    personSkill.getSkill().getStatus())));
        });
        return personSkillDtos;
    }

    public PersonSkillDto postPersonSkill(PersonSkillDto personSkillDto) {
        PersonSkill personSkill = personSkillRepository
                .save(new PersonSkill(personSkillDto.getPersonId(), personSkillDto.getSkillId()));
        return new PersonSkillDto();
    }

    public Integer deletePersonSkillById(Integer personSkillId) {
        Integer resultCode = personSkillRepository.deletePersonSkillByPersonSkillId(personSkillId);
        return resultCode;
    }
}
