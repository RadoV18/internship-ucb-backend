package ucb.internship.backend.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipRequirementDto {
    private Long id;
    private String description;
}
