package ucb.internship.backend.dtos;

public class PersonDto {
    private Long personId;
    private UserDto user;
    private String firstName;
    private String lastName;
    private String ci;
    private String phoneNumber;

    public PersonDto() {
    }

    public PersonDto(Long personId, UserDto userDto, String firstName, String lastName, String ci, String phoneNumber) {
        this.personId = personId;
        this.user = userDto;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ci = ci;
        this.phoneNumber = phoneNumber;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto userDto) {
        this.user = userDto;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PersonDto [personId=" + personId + ", userDto=" + user + ", firstName=" + firstName + ", lastName="
                + lastName + ", ci=" + ci + ", phoneNumber=" + phoneNumber + "]";
    }
}
