package ucb.internship.backend.dtos;

import lombok.*;
import ucb.internship.backend.models.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipDto {
    private Long internshipId;
    private Long institutionId;
    private String title;
    private String description;
    private Integer isApproved;
    private Date startingDate;
    private Date endingDate;
    private Long cityId;
    private List<InternshipBenefitDto> internshipBenefits;
    private List<InternshipRequirementDto> internshipRequirements;
    private List<InternshipRoleDto> internshipRoles;
    private List<InternshipQuestionDto> internshipQuestions;
    private List<MajorDto> majorList;
}
