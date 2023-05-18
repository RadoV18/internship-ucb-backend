package ucb.internship.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ucb.internship.backend.dtos.NotificationDto;
import ucb.internship.backend.services.PushNotificationsService;

import java.sql.Timestamp;

@Service
public class StompNotificationService implements PushNotificationsService {
    @Autowired
    SimpMessagingTemplate template;

    @Override
    public void push(NotificationDto<?> notificationDto, String to) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        notificationDto.setDate(timestamp);
        template.convertAndSend("/all/messages", notificationDto);
    }
}
