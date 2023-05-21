package ucb.internship.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.dtos.SkillDto;
import ucb.internship.backend.services.SkillService;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping()
    public List<SkillDto> getSkillDtos() {
        return skillService.getSkills();
    }
}
