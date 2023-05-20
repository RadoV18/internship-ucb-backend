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
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setIsApproved(user.getApproved());
        userDto.setPassword(user.getPassword());
        userDto.setS3ProfilePicture(user.getS3ProfilePicture());
        userDto.setStatus(user.getStatus());
        return userDto;
    }

}
