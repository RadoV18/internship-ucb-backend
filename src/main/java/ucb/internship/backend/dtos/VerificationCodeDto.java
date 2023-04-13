package ucb.internship.backend.dtos;

public class VerificationCodeDto {
    private String uuid;
    private String email;

    public VerificationCodeDto(String uuid, String email) {
        this.uuid = uuid;
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "VerificationCodeDto [uuid=" + uuid + ", code=" + email + "]";
    }
}
