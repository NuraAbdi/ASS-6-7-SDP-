package users;

import news.News;
import news.NewsAgency;
import notifications.NotificationStrategy;

public class Admin extends User {
    public Admin(String username, String password, NotificationStrategy strategy) {
        super(username, password, strategy);
    }

    // Admin публикует новости через NewsAgency
    public void publish(String category, String content) {
        News news = new News(category, content);
        NewsAgency.getInstance().publishNews(news);
    }
}
