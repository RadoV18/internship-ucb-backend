package ucb.internship.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "institutions")
public class InstitutionsENTITY {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institution_id")
    private Integer institutionId;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "area", length = 20)
    private String area;
    @Column(name = "contact_first_name", length = 50)
    private String contactFirstName;
    @Column(name = "contact_last_name", length = 50)
    private String contactLastName;
    @Column(name = "contact_email", length = 50)
    private String contactEmail;
    @Column(name = "contact_phone", length = 50)
    private String contactPhone;
    @CreationTimestamp
    private LocalDateTime creatioDateTime;
    @UpdateTimestamp
    private LocalDateTime updatDateTime;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonManagedReference
    private UserENTITY userENTITY;
}
