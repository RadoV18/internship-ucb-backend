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
import ucb.internship.backend.services.PersonSkillService;

@RestController
@RequestMapping("/api/personskills")
@CrossOrigin(origins = "*")
public class PersonSkillController {
    @Autowired
    private PersonSkillService personSkillService;

    @GetMapping()
    public List<PersonSkillDto> getPersonSkillDtos() {
        return personSkillService.getPersonSkills();
    }

    @GetMapping(path = "/{personId}")
    public List<PersonSkillDto> getPersonSkillByPersonId(@PathVariable Integer personId) {
        return personSkillService.getPersonSkillByPersonId(personId);
    }

    @PostMapping()
    public PersonSkillDto postPersonSkillDto(@RequestBody PersonSkillDto personSkillDto) {
        return personSkillService.postPersonSkill(personSkillDto);
    }

    @DeleteMapping(path = "/{personSkillId}")
    public ResponseEntity<Integer> deletePersonSkillById(@PathVariable Integer personSkillId) {
        Integer resultCode = personSkillService.deletePersonSkillById(personSkillId);
        return new ResponseEntity<Integer>(resultCode, HttpStatus.OK);
    }
}
