package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.dtos.ApplicantDto;
import ucb.internship.backend.models.Internship;
import ucb.internship.backend.models.InternshipApplication;

import java.util.List;

@Repository
public interface InternshipApplicationRepository extends JpaRepository<InternshipApplication, Long> {
    Integer countAllByInternship(Internship internship);

    @Query(value = """
        SELECT s3o.url
        FROM internship_application ia
        INNER JOIN person p ON ia.person_id = p.person_id
        INNER JOIN ucb_user u ON p.user_id = u.user_id
        INNER JOIN s3_object s3o ON u.s3_profile_picture = s3o.s3_object_id
        WHERE ia.internship_id = :internshipId
    """
    , nativeQuery = true)
    List<String> getProfilePicturesByInternshipId(Long internshipId);

    @Query("""
    SELECT new ucb.internship.backend.dtos.ApplicantDto(u.userId, ia.internshipApplicationId, p.firstName, p.lastName, m.name, u.email, ia.submittedOn, ia.admitted, s3cv.url, s3pp.url)
    FROM InternshipApplication ia
    INNER JOIN Person p ON ia.person.personId = p.personId
    INNER JOIN User u ON p.userUcb.userId = u.userId
    LEFT JOIN Student s ON p.personId = s.person.personId
    LEFT JOIN Graduate g ON p.personId = g.person.personId
    INNER JOIN CampusMajor cm ON s.campusMajor.campusMajorId = cm.campusMajorId OR g.campusMajor.campusMajorId = cm.campusMajorId
    INNER JOIN Major m ON cm.major.majorId = m.majorId
    LEFT JOIN S3Object s3cv ON p.s3Cv.s3ObjectId = s3cv.s3ObjectId
    LEFT JOIN S3Object s3pp ON u.s3ProfilePicture.s3ObjectId = s3pp.s3ObjectId
    WHERE ia.internship.internshipId = :internshipId
    """)
    List<ApplicantDto> getApplicantsByInternshipId(Long internshipId);
}
