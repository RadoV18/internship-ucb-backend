package ucb.internship.backend.dtos;

import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApplicantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String major;
    private String email;
    private Date submittedOn;
    private Integer status;
    private String cvUrl;
    private String profilePictureUrl;
    private List<QuestionResponseDto> questionResponses;
}
