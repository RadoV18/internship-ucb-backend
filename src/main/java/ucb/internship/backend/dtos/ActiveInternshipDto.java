package ucb.internship.backend.dtos;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ActiveInternshipDto {
    private Long id;
    private String title;
    private Date dateFrom;
    private Date dateTo;
    private String city;
    private ApplicantSummaryDto applicants;
}
