package ucb.internship.backend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private String s3ProfilePicture;
}
