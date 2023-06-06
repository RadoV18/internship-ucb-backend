// TODO: change this to token and refresh token
package ucb.internship.backend.dtos;

import java.util.List;

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

    private String token;
    private String type = "Bearer";
    private String refreshToken;
    private List<String> roles;
}
