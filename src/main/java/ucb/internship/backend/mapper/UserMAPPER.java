package ucb.internship.backend.mapper;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ucb.internship.backend.models.UserENTITY;
import ucb.internship.backend.dtos.UserDTO;

@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class UserMAPPER {
    
    public static UserDTO entityToDto(UserENTITY userENTITY) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userENTITY.getUser_id());
        userDTO.setEmail(userENTITY.getEmail());
        userDTO.setIsApproved(userENTITY.getIs_approved());
        userDTO.setPassword(userENTITY.getPassword());
        userDTO.setProfilePicture(userENTITY.getProfile_picture());
        userDTO.setStatus(userENTITY.getStatus());
        return userDTO;
    }
    

}
