package ucb.internship.backend.dtos;

public class InstitutionSignUpDto {
    private String name;
    private String area;
    private String description;
    private String contactFirstName;
    private String contactLastName;
    private String contactEmail;
    private String contactPhone;
    private String contactPosition;
    private String password;
    private String email;

    public InstitutionSignUpDto() {
    }

    public InstitutionSignUpDto(String name, String area, String description, String contactFirstName,
            String contactLastName, String contactEmail, String contactPhone, String contactPosition, String password,
            String email) {
        this.name = name;
        this.area = area;
        this.description = description;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactPosition = contactPosition;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "InstitutionSignUpDto [name=" + name + ", area=" + area + ", description=" + description
                + ", contactFirstName=" + contactFirstName + ", contactLastName=" + contactLastName + ", contactEmail="
                + contactEmail + ", contactPhone=" + contactPhone + ", contactPosition=" + contactPosition
                + ", password=" + password + ", email=" + email + "]";
    }
}
