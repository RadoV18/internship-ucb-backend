package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.internship.backend.models.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    /**
     * saves an institution in the database
     * @param institution the institution to save
     * @return the saved institution
     */
    Institution save(Institution institution);

    Institution findInstitutionByUserUcbEmail(String email);
}
