package ucb.internship.backend.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipApplicationQuestionDto {
    private Long questionId;
    private String response;
}
