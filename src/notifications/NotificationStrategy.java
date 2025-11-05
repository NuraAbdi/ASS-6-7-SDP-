package notifications;

import news.News;
import users.User;

public interface NotificationStrategy {
    void send(User user, News news);
}
