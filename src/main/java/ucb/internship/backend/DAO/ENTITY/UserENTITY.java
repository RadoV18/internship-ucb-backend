package ucb.internship.backend.DAO.ENTITY;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
// @JsonIdentityInfo(
//   generator = ObjectIdGenerators.PropertyGenerator.class, 
//   property = "user_id")
public class UserENTITY {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "password", length = 64)
    private String password;
    @Column(name = "profile_picture", length = 100)
    private String profile_picture;
    @Column(name = "is_approved")
    private Integer is_approved;
    @Column(name = "status")
    private Integer status;
    @JsonIgnore
    @OneToOne(mappedBy = "userENTITY", cascade = CascadeType.ALL)
    private InstitutionsENTITY institutionsENTITY;
}
