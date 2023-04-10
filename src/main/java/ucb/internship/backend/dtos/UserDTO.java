package ucb.internship.backend.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private Integer userId;
    private String email;
    private Integer isApproved;
    private String password;
    private String profilePicture;
    private Integer status;


    
}
