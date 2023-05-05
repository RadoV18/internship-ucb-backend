package ucb.internship.backend.mailing;

import java.util.Hashtable;

public class MailjetTemplates extends Hashtable<Template, Integer> {

    public MailjetTemplates ()
    {
        this.put(Template.BASIC, 4753494);
        this.put(Template.VERIFICATION_CODE, 4753876);
    }
}
