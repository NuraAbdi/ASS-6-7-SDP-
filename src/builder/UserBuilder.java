package builder;

import model.User;
import strategy.NotificationFactory;
import strategy.NotificationStrategy;

public class UserBuilder {
    private String username;
    private String password;
    private NotificationStrategy strategy;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;эп
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setNotificationStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public User build() {
        // defaults
        if (strategy == null) strategy = NotificationFactory.create("email");
        return new User(username, password, strategy);
    }
}
