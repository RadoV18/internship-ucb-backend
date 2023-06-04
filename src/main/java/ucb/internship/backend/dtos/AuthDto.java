// TODO: change this to token and refresh token
package ucb.internship.backend.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthDto {
    private Long userId;
    private Long id;
    private Integer accountType;
    private String name;
    private String email;
    private String profilePictureUrl;
}
