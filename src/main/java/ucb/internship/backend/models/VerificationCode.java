package ucb.internship.backend.models;

import jakarta.persistence.*;
import ucb.internship.backend.dtos.VerificationCodeDto;

@Entity
@Table(name = "verification_code", schema = "public")
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verification_code_id")
    private Long verificationCodeId;
    private String uuid;
    private String code;
    private boolean status;

    public VerificationCode(){
    }

    public VerificationCode(String uuid, String code, boolean status) {
        this.uuid = uuid;
        this.code = code;
        this.status = status;
    }

    public Long getVerificationCodeId() {
        return verificationCodeId;
    }

    public void setVerificationCodeId(Long verificationCodeId) {
        this.verificationCodeId = verificationCodeId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VerificationCode{" +
                "verificationCodeId=" + verificationCodeId +
                ", uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
