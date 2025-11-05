package users;

import news.News;
import notifications.NotificationStrategy;

public class User {
    private final String username;
    private final String password;
    private NotificationStrategy notificationStrategy;
    private boolean subscribed;

    public User(String username, String password, NotificationStrategy notificationStrategy) {
        this.username = username;
        this.password = password;
        this.notificationStrategy = notificationStrategy;
        this.subscribed = false;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setNotificationStrategy(NotificationStrategy strategy) {
        this.notificationStrategy = strategy;
        System.out.println("User " + username + " changed notification strategy.");
    }

    public NotificationStrategy getNotificationStrategy() {
        return notificationStrategy;
    }

    public void update(News news) {
        // вызывается агентством при новой новости
        if (notificationStrategy != null && subscribed) {
            notificationStrategy.send(this, news);
        }
    }

    public boolean isSubscribed() { return subscribed; }
    public void setSubscribed(boolean subscribed) { this.subscribed = subscribed; }
}
