package users;

import notifications.NotificationFactory;
import notifications.NotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final List<User> users = new ArrayList<>();

    public UserManager() {
        //login parol ADMINA
        NotificationStrategy defaultStrategy = NotificationFactory.create("email");
        Admin admin = new Admin("Nura", "2007", defaultStrategy);
        users.add(admin);
    }

    public boolean register(String username, String password, String strategyName) {
        if (findByUsername(username) != null) {
            return false; //V nachale
        }
        NotificationStrategy strategy = NotificationFactory.create(strategyName);
        User user = new User(username, password, strategy);
        users.add(user);
        return true;
    }

    public User login(String username, String password) {
        User u = findByUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    public User findByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) return u;
        }
        return null;
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }
}
