package ucb.internship.backend.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {
    private Long studentId;
    private PersonDto person;
    private Long campusMajorId;
    private Integer semester;
    private Boolean status;
}
