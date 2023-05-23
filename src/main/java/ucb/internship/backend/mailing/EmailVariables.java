package ucb.internship.backend.mailing;

public enum EmailVariables {
    VERIFICATION_CODE("verificationCode"),
    APPLICATION_TITLE("title"),
    APPLICATION_EMPLOYER("employer"),
    APPLICATION_STATUS("status"),
    APPLICATION_MESSAGE("message");


    private final String variable;

    EmailVariables(String variable) {
        this.variable = variable;
    }

    public String get() {
        return variable;
    }
}
