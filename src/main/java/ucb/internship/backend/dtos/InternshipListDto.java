package ucb.internship.backend.dtos;

import jakarta.persistence.Access;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipListDto {
    private Long internshipId;
    private String title;
    private String description;
    private Date startingDate;
    private Date endingDate;
    private String city;
    private String institution;
    private String url;
}
