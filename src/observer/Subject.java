package observer;

import model.News;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifySubscribers(News news);
}
