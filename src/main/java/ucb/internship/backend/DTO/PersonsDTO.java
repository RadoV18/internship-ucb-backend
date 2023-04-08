package ucb.internship.backend.DTO;

import lombok.Data;

@Data
public class PersonsDTO {
    
    private Integer person_id;
    private String first_name;
    private String last_name;
    private String ci;
    private String phone_number;
    
}
