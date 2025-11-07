package strategy;

import model.News;
import model.User;

public class EmailNotification implements NotificationStrategy {
    @Override
    public void send(User user, News news) {
        System.out.println("[EMAIL] To: " + user.getUsername() + " | " + news.toString());
    }
}
