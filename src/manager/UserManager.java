package manager;

import builder.UserBuilder;
import model.Admin;
import model.User;
import strategy.NotificationFactory;
import strategy.NotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private final List<User> users = new ArrayList<>();

    public UserManager() {
        // password ADMIN
        Admin admin = new Admin("Nura", "2007", NotificationFactory.create("email"));
        users.add(admin);
    }

    public boolean registerUser(String username, String password, String strategyName) {
        if (findByUsername(username) != null) return false;
        NotificationStrategy strat = NotificationFactory.create(strategyName);
        User u = new UserBuilder()
                .setUsername(username)
                .setPassword(password)
                .setNotificationStrategy(strat)
                .build();
        users.add(u);
        return true;
    }

    public User login(String username, String password) {
        User u = findByUsername(username);
        if (u != null && u.getPassword().equals(password)) return u;
        return null;
    }

    public User findByUsername(String username) {
        for (User u : users) if (u.getUsername().equals(username)) return u;
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
