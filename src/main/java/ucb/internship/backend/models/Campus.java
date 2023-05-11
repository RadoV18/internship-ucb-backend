package ucb.internship.backend.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "campus")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campusId;
    private Long cityId;
    private String name;
    private Boolean status = true;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campus", fetch = FetchType.LAZY)
    private List<CampusMajor> campusMajors;

    public Campus(Long campusId, Long cityId, String name) {
        this.campusId = campusId;
        this.cityId = cityId;
        this.name = name;
    }

    public Campus(Long campusId) {
        this.campusId = campusId;
    }

    public Campus() {
    }

    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<CampusMajor> getCampusMajors() {
        return campusMajors;
    }

    public void setCampusMajors(List<CampusMajor> campusMajors) {
        this.campusMajors = campusMajors;
    }

    @Override
    public String toString() {
        return "Campus [campusId=" + campusId + ", cityId=" + cityId + ", name=" + name + ", status=" + status
                + ", campusMajors=" + campusMajors + "]";
    }
}
