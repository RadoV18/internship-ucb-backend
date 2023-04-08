package ucb.internship.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ucb.internship.backend.models.VerificationCode;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    /**
     * Stores a verification code in the database
     * @param verificationCode the verification code
     * @return the stored verification code
     */
    VerificationCode save(VerificationCode verificationCode);
}
