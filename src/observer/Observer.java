package observer;

import model.News;

public interface Observer {
    void update(News news);
}
