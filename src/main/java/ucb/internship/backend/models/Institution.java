package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "institution")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
    @ToString.Exclude
    private List<Internship> internships;

    private Boolean status;

}
