package ucb.internship.backend.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GraduateDto {
    private Long graduateId;
    private PersonDto person;
    private Date graduationDate;
    private Long campusMajorId;
    private MajorDto major;
    private CampusDto campus;
    private Boolean status;
}
