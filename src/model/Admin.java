package model;


import observer.NewsAgency;
import strategy.NotificationStrategy;

// model.Admin.java
public class Admin extends User {
    public Admin(String username, String password, NotificationStrategy strategy) {
        super(username, password, strategy);
    }

    public void publish(NewsAgency agency, News news) {
        agency.publishNews(news);
    }
}
