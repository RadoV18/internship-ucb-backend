package ucb.internship.backend.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserResDto {
    private Long userId;
    private String email;
    private String profilePicture;
}
