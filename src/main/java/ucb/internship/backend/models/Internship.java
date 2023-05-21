package ucb.internship.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "internship")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Internship {
    @Id
    @Column(name = "internship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipId;

    private String title;
    private String description;
    @Column(name = "is_approved")
    private Integer isApproved;

    @Column(name = "starting_date")
    private Timestamp startingDate;

    @Column(name = "ending_date")
    private Timestamp endingDate;

    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipBenefit> internshipBenefits;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true, mappedBy = "internship")
    private List<InternshipRequirement> internshipRequirements;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipRole> internshipRoles;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipQuestion> internshipQuestions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "internship")
    private List<InternshipMajor> majorList;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "institution_id")
    @ToString.Exclude
    private Institution institution;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "city_id")
    @ToString.Exclude
    private City city;
}
