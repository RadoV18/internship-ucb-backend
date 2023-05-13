package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucb.internship.backend.models.VerificationCode;

import java.util.Optional;

@Repository
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    /**
     * Stores a verification code in the database
     * @param verificationCode the verification code
     * @return the stored verification code
     */
    VerificationCode save(VerificationCode verificationCode);

    /**
     * @param uuid the uuid to look in the database
     * @return the code if it exists
     */
    VerificationCode findByUuidAndStatusIs(String uuid, Boolean status);

    /**
     * @param codeId the code id to look in the database
     */
    void deleteById(Long codeId);
}
