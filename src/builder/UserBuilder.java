package builder;

import model.User;
import strategy.NotificationStrategy;

public class UserBuilder {
    private String username;
    private String password;
    private NotificationStrategy strategy;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public User build() {
        return new User(username, password, strategy);
    }
}
