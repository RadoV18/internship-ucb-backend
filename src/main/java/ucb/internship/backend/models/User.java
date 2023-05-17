package ucb.internship.backend.models;

import at.favre.lib.crypto.bcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "ucb_user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId = 1L;
    private String email;
    @JsonIgnore
    private String password;
    @Column(name = "s3_profile_picture")
    private Long s3ProfilePicture;
    @Column(name = "is_approved")
    private Integer isApproved;
    private Boolean status;
    @JsonBackReference
    @OneToOne(mappedBy = "userUcb", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Institution institution;
    @JsonIgnore
    @OneToOne(mappedBy = "userUcb", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Person person;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "s3_object_id", referencedColumnName = "s3_object_id")
    private S3Object s3Object;

    public User() {
    }

    public User(String email, String password, Long s3ProfilePicture, Integer isApproved, Boolean status) {
        this.email = email;
        this.password = password;
        this.s3ProfilePicture = s3ProfilePicture;
        this.isApproved = isApproved;
        this.status = status;
    }

    public User(Long userId, String email, String password, Long s3ProfilePicture, Integer isApproved, Boolean status,
    Institution institutions, Person person) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.s3ProfilePicture = s3ProfilePicture;
        this.isApproved = isApproved;
        this.status = status;
        this.institution = institutions;
        this.person = person;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public Long getS3ProfilePicture() {
        return s3ProfilePicture;
    }

    public void setS3ProfilePicture(Long s3ProfilePicture) {
        this.s3ProfilePicture = s3ProfilePicture;
    }

    public Integer getApproved() {
        return isApproved;
    }

    public void setApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Integer getIsApproved() {
        return this.isApproved;
    }

    public void setIsApproved(Integer isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public S3Object getS3Object() {
        return this.s3Object;
    }

    public void setS3Object(S3Object s3Object) {
        this.s3Object = s3Object;
    }

    /**
     * @param password The password to be checked
     * @return true if the password is correct, false otherwise
     */
    public boolean authenticate(String password) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), this.password);
        return result.verified;
    }
}
