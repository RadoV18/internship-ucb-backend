package ucb.internship.backend.dtos;

import java.util.Date;

import lombok.Data;
import ucb.internship.backend.models.Persons;


@Data
public class GraduateDto {
    private Integer graduateId;
    private Date graduationDate;
    private Integer campusMajorId;
    private Integer status;
    private Persons person;
}
