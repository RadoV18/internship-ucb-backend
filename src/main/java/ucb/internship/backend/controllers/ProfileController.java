package ucb.internship.backend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ucb.internship.backend.dtos.ProfileDto;
import ucb.internship.backend.dtos.ResponseDto;
import ucb.internship.backend.services.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private ProfileService profileServicedentService;
    public static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileServicedentService = profileService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseDto<ProfileDto>> getStudentProfileByEmail(@PathVariable String email) {
        try{
            ProfileDto studentProfileDto = profileServicedentService.getStudentProfileByEmail(email);
            return ResponseEntity.ok(new ResponseDto<ProfileDto>(studentProfileDto,"Student profile",true));
        }catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping
    public ResponseEntity<ResponseDto<String>> updatePerson(@RequestParam(value = "data")String data,
                                                            @RequestParam(required = false, value = "cvFile") MultipartFile cv ) throws Exception {
        logger.info("data {}",data);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            ProfileDto profileDto = objectMapper.readValue(data, ProfileDto.class);
            String response = profileServicedentService.updateStudentProfile(profileDto,cv);
            return new ResponseEntity<>(new ResponseDto<String>(response,"",true),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
