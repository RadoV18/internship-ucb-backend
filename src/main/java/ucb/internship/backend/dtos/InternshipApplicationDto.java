package ucb.internship.backend.dtos;

import lombok.*;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipApplicationDto {
    private Long internshipId;
    private Long personId;
    private List<InternshipApplicationQuestionDto> internshipApplicationQuestions;
}
