package ucb.internship.backend.DTO;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;
import ucb.internship.backend.DAO.ENTITY.UserENTITY;

@Data
@NoArgsConstructor
public class InstitucionsDTO {

        private Integer institution_id;     
        private String name;
        private String description;
        private String area;
        private String contact_first_name;
        private String contact_last_name;
        private String contact_email;
        private String contact_phone;
        private UserENTITY user_ucb_id;
}
