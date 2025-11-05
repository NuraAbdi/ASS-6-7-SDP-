package notifications;

import news.News;
import users.User;

public class SMSNotification implements NotificationStrategy {
    @Override
    public void send(User user, News news) {
        // Симуляция отправки SMS (короткий формат)
        System.out.println("[SMS] To: " + user.getUsername() + " | " + news.getCategory());
    }
}
