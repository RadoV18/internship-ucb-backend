package ucb.internship.backend.dtos;

public class CityDto {
    private Long cityId;
    private String name;

    public CityDto() {
    }

    public CityDto(Long cityId, String name) {
        this.cityId = cityId;
        this.name = name;
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

    @Override
    public String toString() {
        return "CityDto{" +
            "cityId=" + cityId +
            ", name='" + name + '\'' +
            '}';
    }
}
