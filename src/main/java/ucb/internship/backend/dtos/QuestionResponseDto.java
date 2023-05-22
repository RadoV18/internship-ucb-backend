package ucb.internship.backend.dtos;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuestionResponseDto {
    private Long questionId;
    private String question;
    private String response;
}
