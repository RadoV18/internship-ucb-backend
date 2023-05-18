package ucb.internship.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.models.Institution;
import ucb.internship.backend.models.Internship;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Repository
public interface InternshipRepository  extends JpaRepository<Internship, Integer> {
    List<Internship> findByInternshipId(Integer InternshipId);

    List<Internship> findAllByInstitutionAndIsApprovedIs(Institution institution, Integer isApproved);

    List<Internship> findByIsApproved(Integer isApproved);

    @Query(value = "Select distinct i.internship_id , i.title,i.description,  i.starting_date,i.ending_date, c.name as city\n" +
            "              , i2.name as institution, s3.url\n" +
            "                from internship i, city c , internship_major im , major m, institution i2 , s3_object s3, ucb_user u\n" +
            "                where i.internship_id = im.internship_id and im.major_id = m.major_id\n" +
            "                and i.city_id = c.city_id and i.institution_id = i2.institution_id\n" +
            "                and i2.user_id = u.user_id and s3.s3_object_id = u.s3_profile_picture\n" +
            "                and c.name like :city and i.starting_date >= :startingDate and i.ending_date <= :endingDate \n" +
            "                and m.name like :major  and i.status = true and i.is_approved = 1" +
            "                order by i.internship_id \n" , nativeQuery = true)
    Page<Object[]> findInternshipList(@Param("city") String city,
                                      @Param("startingDate") Timestamp startingDate,
                                      @Param("endingDate") Timestamp endingDate,
                                      @Param("major") String major,
                                      Pageable pageable);
}
