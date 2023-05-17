package ucb.internship.backend.mapper;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ucb.internship.backend.dtos.UserDto;
import ucb.internship.backend.models.User;

@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class UserMapper {
    
    public static UserDto entityToDto(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setIsApproved(user.getApproved());
        userDTO.setPassword(user.getPassword());
        userDTO.setS3ProfilePicture(user.getS3ProfilePicture());
        userDTO.setStatus(user.getStatus());
        return userDTO;
    }

}
