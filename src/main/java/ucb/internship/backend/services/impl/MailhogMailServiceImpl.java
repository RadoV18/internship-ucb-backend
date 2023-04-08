package ucb.internship.backend.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import ucb.internship.backend.exceptions.MailServiceException;
import ucb.internship.backend.services.EmailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailhogMailServiceImpl implements EmailService {
    private final Logger logger = LoggerFactory.getLogger(MailhogMailServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    public MailhogMailServiceImpl(){
    }

    @Override
    public void sendVerificationCode(String email, String code) throws MailServiceException {
        logger.info("Verification code to " + email);
        try {
            MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                    message.setFrom("internship@ucb.edu.bo");
                    message.setTo(email);
                    message.setSubject("Internship by Cato - Código de Verificación");
                    message.setText("""
                            <h1>Bienvenido a Internship by Cato</h1>
                            <p>Tu código de verificación es: %s</p>
                    """.formatted(code), true);

                }
            };
            logger.info("Sending email");
            mailSender.send(messagePreparator);
            logger.info("Email sent succesfully");
        } catch (Exception e) {
            throw new MailServiceException("Error sending verification code", e);
        }
    }
}
