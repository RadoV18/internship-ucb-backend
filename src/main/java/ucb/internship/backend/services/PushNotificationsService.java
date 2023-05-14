package ucb.internship.backend.services;

import ucb.internship.backend.dtos.NotificationDto;

public interface PushNotificationsService {
    void push(NotificationDto<?> notificationDto, String to);
}
