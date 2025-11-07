package model;

import observer.Observer;
import strategy.NotificationStrategy;

import observer.Observer;
public class User implements Observer {
    private final String username;
    private final String password;
    private NotificationStrategy notificationStrategy;
    private boolean subscribed = false;

    public User(String username, String password, NotificationStrategy strategy) {
        this.username = username;
        this.password = password;
        this.notificationStrategy = strategy;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setNotificationStrategy(NotificationStrategy strategy) {
        this.notificationStrategy = strategy;
    }

    public NotificationStrategy getNotificationStrategy() {
        return notificationStrategy;
    }

    public boolean isSubscribed() { return subscribed; }
    public void setSubscribed(boolean s) { subscribed = s; }

    @Override
    public void update(News news) {
        if (subscribed && notificationStrategy != null) {
            notificationStrategy.send(this, news);
        }
    }
}
