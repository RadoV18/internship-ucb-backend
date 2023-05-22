package ucb.internship.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplicantDto {
    private Long id;
    private Long applicationId;
    private String firstName;
    private String lastName;
    private String major;
    private String email;
    private Date submittedOn;
    private Integer status;
    private String cvUrl;
    private String profilePictureUrl;

    public ApplicantDto(Long id, Long applicationId, String firstName, String lastName, String major, String email, Date submittedOn, Integer status, String cvUrl, String profilePictureUrl) {
        this.id = id;
        this.applicationId = applicationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.email = email;
        this.submittedOn = submittedOn;
        this.status = status;
        this.cvUrl = cvUrl;
        this.profilePictureUrl = profilePictureUrl;
    }
}
