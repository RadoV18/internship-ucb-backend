package ucb.internship.backend.mailing;

import java.util.Hashtable;

public class MailjetTemplates extends Hashtable<Template, Integer> {

    public MailjetTemplates () {
        this.put(Template.BASIC, 4753494);
        this.put(Template.VERIFICATION_CODE, 4753876);
        this.put(Template.SIGN_UP_REQUEST_STATUS, 4822428);
        this.put(Template.INTERNSHIP_APPLICATION_UPDATE, 4822431);
    }
}
