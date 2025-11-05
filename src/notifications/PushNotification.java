package notifications;

import news.News;
import users.User;

public class PushNotification implements NotificationStrategy {
    @Override
    public void send(User user, News news) {
        // Симуляция push notification
        System.out.println("[PUSH] To: " + user.getUsername() + " >>> " + news.getCategory());
    }
}
