package news;

import users.User;

import java.util.ArrayList;
import java.util.List;

// Singleton + Subject (Observer pattern)
public class NewsAgency implements Subject {
    private static NewsAgency instance;
    private final List<User> subscribers;
    private final List<News> newsList;

    private NewsAgency() {
        this.subscribers = new ArrayList<>();
        this.newsList = new ArrayList<>();
    }

    public static synchronized NewsAgency getInstance() {
        if (instance == null) {
            instance = new NewsAgency();
        }
        return instance;
    }

    @Override
    public void register(User user) {
        if (!subscribers.contains(user)) {
            subscribers.add(user);
            System.out.println("User " + user.getUsername() + " subscribed to news.");
        }
    }

    @Override
    public void unregister(User user) {
        subscribers.remove(user);
        System.out.println("User " + user.getUsername() + " unsubscribed from news.");
    }

    @Override
    public void notifySubscribers(News news) {
        for (User user : new ArrayList<>(subscribers)) {
            user.update(news); // User реализует поведение при оповещении
        }
    }

    public void publishNews(News news) {
        newsList.add(news);
        System.out.println("News published: " + news.getCategory());
        notifySubscribers(news);
    }

    public List<News> getNewsList() {
        return new ArrayList<>(newsList);
    }

    public List<User> getSubscribers() {
        return new ArrayList<>(subscribers);
    }
}
