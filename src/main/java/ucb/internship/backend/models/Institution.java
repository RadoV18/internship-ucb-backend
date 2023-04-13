package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "institution", schema = "public")
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
    private User user;
    
    public Institution() {
    }


    

    public Institution(Long institutionId, String name, String description, String area, String contactFirstName,
            String contactLastName, String contactEmail, String contactPhone, String contactPosition, User user) {
        this.institutionId = institutionId;
        this.name = name;
        this.description = description;
        this.area = area;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactPosition = contactPosition;
        this.user = user;
    }
    



    public Institution(Long institutionId, String name, String description, String area, String contactFirstName,
            String contactLastName, String contactEmail, String contactPhone, String contactPosition) {
        this.institutionId = institutionId;
        this.name = name;
        this.description = description;
        this.area = area;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactPosition = contactPosition;
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


    
    public User getUser() {
        return user;
    }




    public void setUser(User user) {
        this.user = user;
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
                '}';
    }






}
