package ucb.internship.backend.dtos;

import java.util.Date;

import lombok.Data;
import ucb.internship.backend.models.PersonsENTITY;


@Data
public class GraduateDTO {
    private Integer graduateId;
    private Date graduationDate;
    private Integer campusMajorId;
    private Integer status;
    private PersonsENTITY person;
}
