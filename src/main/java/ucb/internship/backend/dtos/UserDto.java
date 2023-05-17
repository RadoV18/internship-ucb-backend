package ucb.internship.backend.dtos;

import lombok.Data;

@Data
public class UserDto {
    private Long userId;
    private String email;
    private Integer isApproved;
    private String password;
    private Long s3ProfilePicture;
    private boolean status;
}
