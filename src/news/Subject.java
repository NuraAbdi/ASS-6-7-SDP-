package news;

import users.User;

public interface Subject {
    void register(User user);
    void unregister(User user);
    void notifySubscribers(News news);
}
