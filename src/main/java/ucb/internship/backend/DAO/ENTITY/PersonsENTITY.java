package ucb.internship.backend.DAO.ENTITY;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PersonsENTITY {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer person_id;
    @Column(name = "first_name",length = 50)
    private String first_name;
    @Column(name = "last_name", length = 50)
    private String last_name;
    @Column(name = "ci", length = 20)
    private String ci;
    @Column(name = "phone_number", length = 20)
    private String phone_number;
    @CreationTimestamp
    private LocalDateTime creatioDateTime;
    @UpdateTimestamp
    private LocalDateTime updatDateTime;
    
}
