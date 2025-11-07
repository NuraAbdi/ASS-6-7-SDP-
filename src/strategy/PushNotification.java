package strategy;

import model.News;
import model.User;

public class PushNotification implements NotificationStrategy {
    @Override
    public void send(User user, News news) {
        System.out.println("[PUSH] To: " + user.getUsername() + " >>> " + news.getCategory() + " - " + trim(news.getContent()));
    }

    private String trim(String s) {
        if (s.length() <= 60) return s;
        return s.substring(0, 57) + "...";
    }
}
