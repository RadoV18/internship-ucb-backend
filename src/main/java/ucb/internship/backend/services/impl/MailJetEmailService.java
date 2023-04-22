package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.internship.backend.mailing.MailjetMailer;
import ucb.internship.backend.mailing.Recipient;
import ucb.internship.backend.mailing.Template;
import ucb.internship.backend.services.EmailService;

import java.util.Hashtable;

@Service
public class MailJetEmailService implements EmailService {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(MailJetEmailService.class);

    @Autowired
    private MailjetMailer mailjetMailer;

    public MailJetEmailService() {
    }

    @Override
    public void sendEmail(Recipient recipient, Hashtable<String, String> mailVariables, Template template){
        LOGGER.info("Init mail process for a {} email", template.name());
        mailjetMailer.sendEmail(recipient, mailVariables, template);
    }
}
