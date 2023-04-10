package ucb.internship.backend.dtos;

import lombok.Data;
import ucb.internship.backend.models.UserENTITY;


@Data
public class PersonsDTO {
    
    private Integer personId;
    private String firstName;
    private String lastName;
    private String ci;
    private String phoneNumber;
    private UserENTITY user;
}
