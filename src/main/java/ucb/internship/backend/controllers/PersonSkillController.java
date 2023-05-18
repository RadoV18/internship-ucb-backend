package ucb.internship.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.dtos.PersonSkillDto;
import ucb.internship.backend.models.PersonSkill;
import ucb.internship.backend.repositories.PersonSkillRepository;

@RestController
@RequestMapping("/api/personskills")
@CrossOrigin(origins = "*")
public class PersonSkillController {
    @Autowired
    private PersonSkillRepository personSkillRepository;

    @GetMapping()
    public List<PersonSkill> getPersonSkills() {
        return personSkillRepository.findAll();
    }

    @GetMapping(path = "/{personId}")
    public List<PersonSkill> getPersonSkillByPerson(@PathVariable Integer personId) {
        return personSkillRepository.findByPersonId(personId);
    }

    @PostMapping()
    public PersonSkill postPersonSkill(@RequestBody PersonSkillDto personSkillDto) {
        return personSkillRepository
                .save(new PersonSkill(personSkillDto.getPersonId(), personSkillDto.getSkillId()));
    }

    @DeleteMapping(path = "/{personSkillId}")
    public ResponseEntity<Integer> deletePersonSkillById(@PathVariable Integer personSkillId) {
        Integer resultCode = personSkillRepository.deletePersonSkillByPersonSkillId(personSkillId);
        return new ResponseEntity<Integer>(resultCode, HttpStatus.OK);
    }
}
