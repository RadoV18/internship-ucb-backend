package ucb.internship.backend.dtos;

import java.util.List;

public class ApplicantSummaryDto {
    private Integer count;
    private List<String> pictures;

    public ApplicantSummaryDto() {
    }

    public ApplicantSummaryDto(Integer count, List<String> pictures) {
        this.count = count;
        this.pictures = pictures;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "ApplicantSummaryDto{" +
                "count=" + count +
                ", pictures=" + pictures +
                '}';
    }
}
