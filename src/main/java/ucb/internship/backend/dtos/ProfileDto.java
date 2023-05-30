package ucb.internship.backend.dtos;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProfileDto {
    Long personId;
    String firstName;
    String lastName;
    String ci;
    String phoneNumber;
    Integer semester;
    Date graduationDate;
    String major;
    String profilePicture;
    boolean isGraduate;
}
