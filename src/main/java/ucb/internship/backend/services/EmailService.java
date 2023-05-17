package ucb.internship.backend.services;

import ucb.internship.backend.mailing.Recipient;
import ucb.internship.backend.mailing.Template;

import java.util.Hashtable;

public interface EmailService {
    /**
     * Sends an email to the recipient with the given template and variables.
     * @param recipient     the recipient of the email.
     * @param mailVariables the pair of variables/values to be used in the template.
     * @param template      the template to be used.
     */
    void sendEmail(Recipient recipient, Hashtable<String, String> mailVariables, Template template);

}
