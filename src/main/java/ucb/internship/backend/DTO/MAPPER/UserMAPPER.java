package ucb.internship.backend.DTO.MAPPER;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ucb.internship.backend.DAO.ENTITY.UserENTITY;
import ucb.internship.backend.DTO.UserDTO;

@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class UserMAPPER {
    
    public static UserDTO entityToDto(UserENTITY userENTITY) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(userENTITY.getUser_id());
        userDTO.setEmail(userENTITY.getEmail());
        userDTO.setIs_approved(userENTITY.getIs_approved());
        userDTO.setPassword(userENTITY.getPassword());
        userDTO.setProfile_picture(userENTITY.getProfile_picture());
        userDTO.setStatus(userENTITY.getStatus());
        return userDTO;
    }
    

}
