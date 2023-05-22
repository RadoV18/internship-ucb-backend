package ucb.internship.backend.dtos;

import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InternshipDetailsDto {
    private Long internshipId;
    private String title;
    private String description;
    private Date startingDate;
    private Date endingDate;
    private InstitutionResDto institution;
    private CityDto city;
    private List<InternshipBenefitDto> internshipBenefits;
    private List<InternshipRequirementDto> internshipRequirements;
    private List<InternshipRoleDto> internshipRoles;
    private List<InternshipQuestionDto> internshipQuestions;
    private List<MajorDto> majorList;
}
