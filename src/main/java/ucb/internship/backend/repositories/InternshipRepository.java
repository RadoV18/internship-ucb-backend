package ucb.internship.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ucb.internship.backend.models.Internship;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Repository
@Service
public interface InternshipRepository  extends JpaRepository<Internship, Integer> {
    List<Internship> findByInternshipId(Integer InternshipId);

    List<Internship> findAllByInstitutionIdAndIsApprovedIs(Integer institutionId, Integer isApproved);

    @Query(value = "Select distinct i.internship_id , i.title,i.description,  i.starting_date,i.ending_date, c.name as city\n" +
            ", i2.name as institution, s3.url\n" +
            "from internship i join city c on i.city_id = c.city_id\n" +
            "    left join internship_major im on i.internship_id = im.internship_id\n" +
            "    left join institution i2 on i.institution_id = i2.institution_id\n" +
            "    left join ucb_user uu on i2.user_id = uu.user_id\n" +
            "    left join s3_object s3 on uu.s3_profile_picture = s3.s3_object_id\n" +
            "    where c.name LIKE :city and i.starting_date >= :startingDate and i.ending_date <= :endingDate\n" +
            "    and im.major_id in :majors" +
            "    and i.status = true and i.is_approved = 1 " +
            "order by i.internship_id  asc\n" , nativeQuery = true)
    Page<Object[]> findInternshipList(@Param("city") String city,
                                      @Param("startingDate") Timestamp startingDate,
                                      @Param("endingDate") Timestamp endingDate,
                                      @Param("majors") Collection<Integer> majorIds,
                                      Pageable pageable);
}
