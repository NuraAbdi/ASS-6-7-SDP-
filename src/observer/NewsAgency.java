package observer;

import model.News;
import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private final List<Observer> subscribers = new ArrayList<>();
    private final List<News> newsList = new ArrayList<>();

    @Override
    public void register(Observer o) {
        if (!subscribers.contains(o)) subscribers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifySubscribers(News news) {
        List<Observer> copy = new ArrayList<>(subscribers);
        for (Observer o : copy) {
            o.update(news);
        }
    }

    public void publishNews(News news) {
        newsList.add(news);
        System.out.println("\n📰 News published: " + news.toString());
        notifySubscribers(news);
    }

    public List<News> getNewsList() {
        return new ArrayList<>(newsList);
    }

    public List<Observer> getSubscribers() {
        return new ArrayList<>(subscribers);
    }
}
