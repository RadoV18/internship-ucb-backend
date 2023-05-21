package ucb.internship.backend.services;

import java.util.List;

import ucb.internship.backend.dtos.SkillDto;

public interface SkillService {
    List<SkillDto> getSkills();
}
