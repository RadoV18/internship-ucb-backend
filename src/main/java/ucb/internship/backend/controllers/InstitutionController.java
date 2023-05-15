package ucb.internship.backend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ucb.internship.backend.models.Institution;
import ucb.internship.backend.repositories.InstitutionRepository;

@RestController
@RequestMapping("/api/institutions")
@CrossOrigin(origins = "*")
public class InstitutionController {
    @Autowired
    private InstitutionRepository institutionRepository;

    @GetMapping(path = "/{institutionId}")
    public Optional<Institution> getInstitutionById(@PathVariable Long institutionId) {
        return institutionRepository.findById(institutionId);
    }
}
