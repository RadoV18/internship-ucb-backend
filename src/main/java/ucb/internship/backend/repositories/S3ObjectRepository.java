package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.models.S3Object;
import ucb.internship.backend.models.User;

@Repository
public interface S3ObjectRepository extends JpaRepository<S3Object, Long> {
    /**
     * saves an S3 Object in the database
     * @param s3Object the S3 Object to save
     * @return the saved S3 Object
     */
    S3Object save(S3Object s3Object);
}
