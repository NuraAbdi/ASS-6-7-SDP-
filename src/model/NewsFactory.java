package model;

import observer.Observer;
import strategy.NotificationStrategy;

public class NewsFactory {
    public static News createNews(String category, String content) {
        if (category == null || category.trim().isEmpty()) category = "General";
        if (content == null) content = "";
        return new News(category.trim(), content.trim());
    }
}
