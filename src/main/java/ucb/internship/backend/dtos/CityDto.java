package ucb.internship.backend.dtos;

public class CityDto {
    private Integer cityId;
    private String name;

    public CityDto() {
    }

    public CityDto(Integer cityId, String name) {
        this.cityId = cityId;
        this.name = name;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
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
