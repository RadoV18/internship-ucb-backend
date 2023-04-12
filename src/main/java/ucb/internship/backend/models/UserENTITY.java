package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ucb_user")
public class UserENTITY {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "password", length = 64)
    private String password;
    @Column(name = "profile_picture", length = 100)
    private String profilePicture;
    @Column(name = "is_approved")
    private Integer isApproved;
    @Column(name = "status")
    private Integer status;
    @JsonBackReference
    @OneToOne(mappedBy = "userENTITY", cascade = CascadeType.ALL)
    @ToString.Exclude
    private InstitutionsENTITY institutionsENTITY;
    @JsonIgnore
    @OneToOne(mappedBy = "userENTITY", cascade = CascadeType.ALL)
    @ToString.Exclude
    private PersonsENTITY personsENTITY;

}
