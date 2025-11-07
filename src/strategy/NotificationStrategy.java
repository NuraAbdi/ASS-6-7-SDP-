package strategy;

import model.News;
import model.User;

public interface NotificationStrategy {
    void send(User user, News news);
}
