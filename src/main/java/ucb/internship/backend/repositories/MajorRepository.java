package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.models.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, Integer>{
    @Query(value = "Select m from Major m , Student s, CampusMajor c " +
            "where s.campusMajorId = c.campusMajorId " +
            "and c.major.majorId = m.majorId " +
            "and s.studentId = :studentId")
    Major findMajorByStudentId(Long studentId);

    @Query(value = "Select m from Major m , Graduate g, CampusMajor c " +
            "where g.campusMajorId = c.campusMajorId " +
            "and c.major.majorId = m.majorId " +
            "and g.graduateId = :graduateId")
    Major findMajorByGraduateId(Long graduateId);
}
