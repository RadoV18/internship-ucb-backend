package ucb.internship.backend.mailing;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Hashtable;

@Component
public class MailjetMailer {

    public static Logger LOGGER = LoggerFactory.getLogger(MailjetMailer.class);

    @Value("${mailjet.key}")
    private String key;

    @Value("${mailjet.secret}")
    private String secret;
    MailjetClient client;

    public MailjetMailer() {

    }

    /**
     * Wrapper for sending emails through MailJet
     * @param recipient the recipient of the email
     * @param mailVariables the variables to be used in the email template paired in a hashtable
     * @param template the template to be used
     */
    public void sendEmail(Recipient recipient, Hashtable<String, String> mailVariables, Template template) {
        LOGGER.info("Creating MailJet client - Key {} - Secret {}", !key.isEmpty(), !secret.isEmpty());
        client = new MailjetClient(ClientOptions.builder().apiKey(key).apiSecretKey(secret).build());

        var request = buildRequest(recipient, getTemplateVariables(mailVariables), template);

        LOGGER.info("Sending {} email to {}", template.name(), recipient.email());
        try {
            var response = client.post(request);

            if (response.getStatus() == HttpStatus.OK.value()) {
                LOGGER.info("{} email sent to {}", template.name(), recipient.email());
            }
            else {
                LOGGER.error("Mailjet could not process {} email to {} - HTTP Status {} - Response {}",
                        template.name(), recipient.email(), response.getStatus(), response.getData());
            }
        }
        catch (MailjetException e) {
            LOGGER.error("Error sending {} email to {} - {}", template.name(), recipient.email(), e.getMessage());
        }
    }

    /**
     * Builds a MailjetRequest with the given parameters
     * @param recipient the recipient of the email
     * @param mailVariables the parsed variables to be used in the email template
     * @param template the template to be used
     * @return MailjetRequest with the given parameters
     */
    private MailjetRequest buildRequest(Recipient recipient, JSONObject mailVariables, Template template) {
        return new MailjetRequest(Emailv31.resource)
            .property(Emailv31.MESSAGES, new JSONArray()
                .put(new JSONObject()
                        .put(Emailv31.Message.TO, getRecipient(recipient))
                        .put(Emailv31.Message.TEMPLATEID, getTemplateId(template))
                        .put(Emailv31.Message.TEMPLATELANGUAGE, true)
                        .put(Emailv31.Message.SUBJECT, getSubject(template))
                        .put(Emailv31.Message.VARIABLES, mailVariables)
                )
            );
    }

    /**
     * Builds a JSONObject with the mail variables needed in Mailjet
     * @param mailVariables variables paired in a hashtable
     * @return JSONObject with the parsed variables
     */
    private JSONObject getTemplateVariables(Hashtable<String, String> mailVariables) {
        var JSONVariables = new JSONObject();

        for (var key : mailVariables.keySet()) {
            JSONVariables.put(key, mailVariables.get(key));
        }

        return JSONVariables;
    }

    /**
     * Gets the subject of the email based on the template
     * @param template the template used to get the subject
     * @return the subject of the email, defaulted to an undefined subject text
     */
    private String getSubject(Template template) {
        return new SubjectTemplates().getOrDefault(template, "Undefined subject template");
    }

    /**
     * Gets the Mailjet template id of the email based on the template
     * @param template the template used to get the Mailjet template id
     * @return the Mailjet template id, defaulted to the basic template
     */
    private int getTemplateId(Template template) {
        var mailjetTemplates = new MailjetTemplates();
        return mailjetTemplates.getOrDefault(template, mailjetTemplates.get(Template.BASIC));
    }

    /**
     * Gets the recipient of the email in a JSONArray
     * @param recipient the recipient of the email
     * @return the recipient of the email in a JSONArray
     */
    private JSONArray getRecipient(Recipient recipient) {
        return new JSONArray().put(recipient.toJson());
    }
}
