package model;

import java.time.LocalDateTime;

public class News {
    private final String category;
    private final String content;
    private final LocalDateTime createdAt;

    public News(String category, String content) {
        this.category = category;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public String getCategory() { return category; }
    public String getContent() { return content; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return "[" + category + "] " + content;
    }
}
