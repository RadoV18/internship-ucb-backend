package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "institution")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institution_id")
    private Long institutionId;
    private String name;
    private String description;
    private String area;
    @Column(name = "contact_first_name")
    private String contactFirstName;
    @Column(name = "contact_last_name")
    private String contactLastName;
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "contact_phone")
    private String contactPhone;
    @Column(name = "contact_position")
    private String contactPosition;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonManagedReference
    private User userUcb;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "institution")
    private List<Internship> internships;

    private Boolean status;

    public Institution() {
    }

    public Institution(Long institutionId, String name, String description, String area, String contactFirstName, String contactLastName, String contactEmail, String contactPhone, String contactPosition, Boolean status) {
        this.institutionId = institutionId;
        this.name = name;
        this.description = description;
        this.area = area;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactPosition = contactPosition;
        this.status = status;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public User getUserUcb() {
        return userUcb;
    }

    public void setUserUcb(User user) {
        this.userUcb = user;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "institutionId=" + institutionId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", area='" + area + '\'' +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactPosition='" + contactPosition + '\'' +
                ", status=" + status +
                '}';
    }
}
