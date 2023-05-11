package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.dtos.ApplicantDto;
import ucb.internship.backend.dtos.ApplicantSummaryDto;
import ucb.internship.backend.models.InternshipApplication;

import java.util.List;

@Repository
public interface InternshipApplicationRepository extends JpaRepository<InternshipApplication, Long> {
    Integer countAllByInternshipId(Long internshipId);

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
    SELECT new ucb.internship.backend.dtos.ApplicantDto(u.userId, p.firstName, p.lastName, m.name, u.email, ia.submittedOn, ia.admitted, s3cv.url, s3pp.url)
    FROM InternshipApplication ia
    INNER JOIN Person p ON ia.personId = p.personId
    INNER JOIN User u ON p.userId = u.userId
    LEFT JOIN Student s ON p.personId = s.personId
    LEFT JOIN Graduate g ON p.personId = g.personId
    INNER JOIN CampusMajor cm ON s.campusMajorId = cm.campusMajorId OR g.campusMajorId = cm.campusMajorId
    INNER JOIN Major m ON cm.major.majorId = m.majorId
    LEFT JOIN S3Object s3cv ON p.s3Cv = s3cv.s3ObjectId
    LEFT JOIN S3Object s3pp ON u.s3ProfilePicture = s3pp.s3ObjectId
    WHERE ia.internshipId = :internshipId
    """)
    List<ApplicantDto> getApplicantsByInternshipId(Integer internshipId);
}
