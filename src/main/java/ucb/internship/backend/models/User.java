package ucb.internship.backend.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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
    private boolean isApproved;
    private boolean status;

    public User() {
    }

    public User(String email, String password, Long s3ProfilePicture, boolean isApproved, boolean status) {
        this.email = email;
        this.password = password;
        this.s3ProfilePicture = s3ProfilePicture;
        this.isApproved = isApproved;
        this.status = status;
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

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
