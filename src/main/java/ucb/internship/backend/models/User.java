package ucb.internship.backend.models;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;
import ucb.internship.backend.jwt.models.Role;

@Entity
@Table(name = "ucb_user", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId = 1L;

    private String email;

    @JsonIgnore
    private String password;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "s3_profile_picture", referencedColumnName = "s3_object_id")
    private S3Object s3ProfilePicture;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * @param password The password to be checked
     * @return true if the password is correct, false otherwise
     */
    public boolean authenticate(String password) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), this.password);
        return result.verified;
    }
}
