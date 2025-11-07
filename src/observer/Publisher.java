package observer;

import model.User;
import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<User> subscribers = new ArrayList<>();

    public void subscribe(User user) {
        subscribers.add(user);
        System.out.println(user.getUsername() + " subscribed to news.");
    }

    public void unsubscribe(User user) {
        subscribers.remove(user);
        System.out.println(user.getUsername() + " unsubscribed from news.");
    }

    public void publishArticle(String article) {
        System.out.println("\nNew article published: " + article);
        for (User user : subscribers) {
            System.out.println("[LOG] Sending notification: " + user.getUsername() + ", new article: " + article);
            user.notifyUser("new article: " + article);
        }
    }
}
