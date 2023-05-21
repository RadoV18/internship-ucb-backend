package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ucb.internship.backend.models.InternshipApplicationQuestion;

@Repository
public interface InternshipApplicationQuestionRepository extends JpaRepository<InternshipApplicationQuestion, Integer> {

}
