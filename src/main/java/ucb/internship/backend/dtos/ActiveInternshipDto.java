package ucb.internship.backend.dtos;

import java.sql.Timestamp;

public class ActiveInternshipDto {
    private Long id;
    private String title;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    private String city;
    private ApplicantSummaryDto applicants;

    public ActiveInternshipDto() {
    }

    public ActiveInternshipDto(Long id, String title, Timestamp dateFrom, Timestamp dateTo, String city, ApplicantSummaryDto applicants) {
        this.id = id;
        this.title = title;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.city = city;
        this.applicants = applicants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ApplicantSummaryDto getApplicants() {
        return applicants;
    }

    public void setApplicants(ApplicantSummaryDto applicants) {
        this.applicants = applicants;
    }

    @Override
    public String toString() {
        return "ActiveInternshipDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", city='" + city + '\'' +
                ", applicants=" + applicants +
                '}';
    }
}
