package ucb.internship.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "s3_object", schema = "public")
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
    @OneToOne(mappedBy = "s3Object", cascade = CascadeType.ALL)
    private User userUcb;


    public S3Object() {
    }

    public S3Object(String url, boolean status) {
        this.url = url;
        this.status = status;
    }

    public Long getS3ObjectId() {
        return s3ObjectId;
    }

    public void setS3ObjectId(Long s3ObjectId) {
        this.s3ObjectId = s3ObjectId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "S3Object{" +
                "s3ObjectId=" + s3ObjectId +
                ", url='" + url + '\'' +
                ", status=" + status +
                '}';
    }
}
