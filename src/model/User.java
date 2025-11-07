package model;

import strategy.NotificationStrategy;

public class User {
    private String username;
    private String password;
    private NotificationStrategy notificationStrategy;

    public User(String username, String password, NotificationStrategy strategy) {
        this.username = username;
        this.password = password;
        this.notificationStrategy = strategy;
    }

    public void notifyUser(String message) {
        notificationStrategy.sendNotification(username + ": " + message);
    }

    public String getUsername() { return username; }
}
