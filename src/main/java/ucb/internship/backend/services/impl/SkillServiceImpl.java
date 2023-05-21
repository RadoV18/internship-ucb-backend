package ucb.internship.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.internship.backend.dtos.SkillDto;
import ucb.internship.backend.models.Skill;
import ucb.internship.backend.repositories.SkillRepository;
import ucb.internship.backend.services.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<SkillDto> getSkills() {
        List<SkillDto> skillDtos = new ArrayList<>();
        List<Skill> skills = skillRepository.findAll();
        skills.forEach((skill) -> {
            skillDtos.add(new SkillDto(skill.getSkillId(), skill.getName(), skill.getStatus()));
        });
        return skillDtos;
    }
}
