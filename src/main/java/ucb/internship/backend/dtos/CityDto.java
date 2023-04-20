package ucb.internship.backend.dtos;

public class CityDto {
    private Integer cityId;
    private String name;

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
        return "CityDTO{" +
                "cityId=" + cityId +
                ", name='" + name + '\'' +
                '}';
    }
}
