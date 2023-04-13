package ucb.internship.backend.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String email;
    private boolean isApproved;
    private String password;
    private Long s3ProfilePicture;
    private boolean status;


    
}
