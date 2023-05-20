package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "s3_object", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class S3Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s3_object_id")
    @JsonIgnore
    private Long s3ObjectId;
    private String url;
    @JsonIgnore
    private boolean status;

    @JsonBackReference
    @ToString.Exclude
    @OneToOne(mappedBy = "s3ProfilePicture", cascade = CascadeType.ALL)
    private User userUcb;

    @JsonBackReference
    @ToString.Exclude
    @OneToOne(mappedBy = "s3Cv", cascade = CascadeType.ALL)
    private Person person;
}
