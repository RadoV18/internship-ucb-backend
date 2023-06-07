package ucb.internship.backend.models;

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
@Table(name = "person")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personId")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "first_name",length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "ci", length = 20)
    private String ci;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "s3_cv", referencedColumnName = "s3_object_id")
    @ToString.Exclude
    private S3Object s3Cv;

    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User userUcb;

    @JsonIgnore
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Graduate graduate;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private Student student;
}
