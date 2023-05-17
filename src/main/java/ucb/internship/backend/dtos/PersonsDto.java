package ucb.internship.backend.dtos;

import lombok.Data;
import ucb.internship.backend.models.User;


@Data
public class PersonsDto {
    
    private Integer personId;
    private String firstName;
    private String lastName;
    private String ci;
    private String phoneNumber;
    private User user;
}
