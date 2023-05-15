package ucb.internship.backend.dtos;

import java.sql.Timestamp;

public class NotificationDto<T> {
    private String url;
    private String message;
    private Timestamp date;
    private String type;

    public NotificationDto() {
    }

    public NotificationDto(String url, String message, Timestamp date, String type) {
        this.url = url;
        this.message = message;
        this.date = date;
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NotificationDto{" +
                "url='" + url + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}
