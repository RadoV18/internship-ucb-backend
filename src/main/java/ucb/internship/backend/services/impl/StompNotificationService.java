package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ucb.internship.backend.services.PushNotificationsService;

@Service
public class StompNotificationService implements PushNotificationsService {
    @Autowired
    SimpMessagingTemplate template;

    @Override
    public void push(String text, String to) {
        template.convertAndSend("/all/messages", text);
    }
}
