import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String news) {
        for (Observer o : observers) {
            o.update(news);
        }
    }

    // Симуляция публикации статьи
    public void publishArticle(String title) {
        System.out.println("\n📰 New article published: " + title);
        notifyObservers(title);
    }
}
