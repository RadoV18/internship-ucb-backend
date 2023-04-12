package ucb.internship.backend.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "persons")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "personId")
public class PersonsENTITY {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "first_name",length = 50)
    private String firstName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column(name = "ci", length = 20)
    private String ci;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
    @CreationTimestamp
    private LocalDateTime creatioDateTime;
    @UpdateTimestamp
    private LocalDateTime updatDateTime;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id", referencedColumnName = "user_id")
    private UserENTITY userENTITY;
    @JsonIgnore
    @OneToOne(mappedBy = "personsENTITY", cascade = CascadeType.ALL)
    private GraduateENTITY graduateENTITY;
}
