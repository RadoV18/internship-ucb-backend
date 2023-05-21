package ucb.internship.backend.dtos;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipApiDto {
    private Long internshipId;
    private String institution;
    private String profilePicture;
    private String title;
    private String description;
    private String city;
    private Integer isApproved;
    private Date startingDate;
    private Date endingDate;
    private List<String> internshipBenefits;
    private List<String> internshipRequirements;
    private List<String> internshipRoles;
    private List<String> internshipQuestions;
    private List<String> majorList;
}