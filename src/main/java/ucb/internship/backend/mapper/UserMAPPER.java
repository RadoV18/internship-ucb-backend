package ucb.internship.backend.mapper;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ucb.internship.backend.dtos.UserDTO;
import ucb.internship.backend.models.User;

@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class UserMAPPER {
    
    public static UserDTO entityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setApproved(user.isApproved());
        userDTO.setPassword(user.getPassword());
        userDTO.setS3ProfilePicture(user.getS3ProfilePicture());
        userDTO.setStatus(user.getStatus());
        return userDTO;
    }
    

}
