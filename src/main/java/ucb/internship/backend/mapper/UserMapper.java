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
        userDto.setS3ProfilePicture(user.getS3ProfilePicture().getUrl());
        return userDto;
    }

}
