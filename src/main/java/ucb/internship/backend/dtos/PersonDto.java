package ucb.internship.backend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PersonDto {
    private Long personId;
    private UserDto user;
    private String firstName;
    private String lastName;
    private String ci;
    private String phoneNumber;
    private String s3Cv;
}
