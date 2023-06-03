package ucb.internship.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.Internship;

import java.sql.Date;
import java.util.List;

@Repository
public interface InternshipRepository  extends JpaRepository<Internship, Long> {
    List<Internship> findByInternshipId(Long InternshipId);

    List<Internship> findAllByInstitutionAndIsApprovedIs(Institution institution, Integer isApproved);

    List<Internship> findByIsApproved(Integer isApproved);

    @Query(value = """
    SELECT DISTINCT i.*
    FROM internship i
    INNER JOIN city c on i.city_id = c.city_id
    INNER JOIN internship_major im on i.internship_id = im.internship_id
    INNER JOIN major mj on im.major_id = mj.major_id
    WHERE i.is_approved = 1
    AND c.name like :city
    AND i.starting_date >= :startingDate
    AND i.ending_date <= :endingDate
    AND mj.name like :major
    AND i.status = true
    ORDER BY i.internship_id
    """ , nativeQuery = true)
    Page<Internship> findInternshipList(@Param("city") String city,
                                        @Param("startingDate") Date startingDate,
                                        @Param("endingDate") Date endingDate,
                                        @Param("major") String major,
                                        Pageable pageable);
    List<Internship> findByTitleLikeIgnoreCaseOrInstitutionNameLikeIgnoreCaseAndIsApproved(String title, String institutionName, Integer isApproved);
    List<Internship> findTop5ByIsApprovedOrderByInternshipIdDesc(Integer isApproved);
}
