package ucb.internship.backend.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InstitutionResDto {
    private Long institutionId;
    private String name;
    private String description;
    private String area;
    private String contactFirstName;
    private String contactLastName;
    private String contactEmail;
    private String contactPhone;
    private String contactPosition;
    private UserResDto user;
}
