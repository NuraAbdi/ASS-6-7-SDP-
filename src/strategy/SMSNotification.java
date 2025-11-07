package strategy;

import model.News;
import model.User;

public class SMSNotification implements NotificationStrategy {
    @Override
    public void send(User user, News news) {
        System.out.println("[SMS] To: " + user.getUsername() + " | " + news.getCategory() + " : " + trim(news.getContent()));
    }

    private String trim(String s) {
        if (s.length() <= 40) return s;
        return s.substring(0, 37) + "...";
    }
}
