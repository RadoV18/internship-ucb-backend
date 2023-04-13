package ucb.internship.backend.dtos;

public class VerificationCodeReqDto {
    private String uuid;
    private String code;

    public VerificationCodeReqDto() {
    }

    public VerificationCodeReqDto(String uuid, String code) {
        this.uuid = uuid;
        this.code = code;
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

    @Override
    public String toString() {
        return "VerificationCodeReqDto{" +
                "uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
