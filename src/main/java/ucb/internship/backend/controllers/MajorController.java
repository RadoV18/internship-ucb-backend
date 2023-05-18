package ucb.internship.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ucb.internship.backend.dtos.MajorDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.services.MajorService;

import java.util.List;

@RestController
@RequestMapping("/api/majors")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<MajorDto>>> getAllMajors(@RequestParam(required = false, defaultValue = "majorId") String sort) {
        if (!(sort.equals("majorId") || sort.equals("name"))) {
            return ResponseEntity.badRequest().body(new ResponseDto<>(null, "Invalid sort parameter", false));
        }
        List<MajorDto> majors = majorService.getAllMajors(sort);
        return ResponseEntity.ok(new ResponseDto<>(majors, null, true));
    }
}
