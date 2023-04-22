package ucb.internship.backend.mailing;

public enum EmailVariables {
    VERIFICATION_CODE("verificationCode");

    private final String variable;

    EmailVariables(String variable) {
        this.variable = variable;
    }

    public String get() {
        return variable;
    }
}
