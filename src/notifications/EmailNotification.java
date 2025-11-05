package notifications;

import news.News;
import users.User;

public class EmailNotification implements NotificationStrategy {
    @Override
    public void send(User user, News news) {
        // Симуляция отправки email
        System.out.println("[EMAIL] To: " + user.getUsername() + " | " + news.getCategory() + " -- " + news.getContent());
    }
}
