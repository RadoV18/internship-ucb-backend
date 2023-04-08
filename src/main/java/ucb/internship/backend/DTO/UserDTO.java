package ucb.internship.backend.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Integer user_id;
    private String email;
    private Integer is_approved;
    private String password;
    private String profile_picture;
    private Integer status;
    

    
}
