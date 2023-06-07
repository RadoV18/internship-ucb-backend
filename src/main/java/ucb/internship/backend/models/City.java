package ucb.internship.backend.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;
    @Column(name = "country_id")
    private Long countryId;
    private String name;
    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "city")
    private List<Internship> internships;

    public City() {
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
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

    public List<Internship> getInternships() {
        return internships;
    }

    public void setInternships(List<Internship> internships) {
        this.internships = internships;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", countryId=" + countryId +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
