package ucb.internship.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    private Long userId;
    private String firstName;
    private String lastName;
    private String ci;
    private String phoneNumber;
    @Column(name = "s3_cv")
    private Long s3Cv;

    public Person(Long personId) {
        this.personId = personId;
    }

    public Person() {
    }

    public Person(Long personId, Long userId, String firstName, String lastName, String ci, String phoneNumber,
            Long s3Cv) {
        this.personId = personId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ci = ci;
        this.phoneNumber = phoneNumber;
        this.s3Cv = s3Cv;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getS3Cv() {
        return s3Cv;
    }

    public void setS3Cv(Long s3Cv) {
        this.s3Cv = s3Cv;
    }

    @Override
    public String toString() {
        return "Person [personId=" + personId + ", userId=" + userId + ", firstName=" + firstName + ", lastName="
                + lastName + ", ci=" + ci + ", phoneNumber=" + phoneNumber + ", s3Cv=" + s3Cv + "]";
    }
}
