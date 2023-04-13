package ucb.internship.backend.dtos;
import lombok.Data;
import lombok.NoArgsConstructor;
import ucb.internship.backend.models.User;

@Data
@NoArgsConstructor
public class InstitucionsDTO {

        private Long institutionId;     
        private String name;
        private String description;
        private String area;
        private String contactFirstName;
        private String contactLastName;
        private String contactEmail;
        private String contactPhone;
        private User user;
}
