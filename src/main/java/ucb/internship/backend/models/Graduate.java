package ucb.internship.backend.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "graduates")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "graduateId")
public class Graduate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long graduateId;

    @Column(name = "graduation_date")
    private Date graduationDate;
    @Column(name = "status")
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ToString.Exclude
    private Person person;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private CampusMajor campusMajor;
}
