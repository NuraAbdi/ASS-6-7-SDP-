public class Subscriber implements Observer {
    private String name;
    private NotificationStrategy strategy;

    public Subscriber(String name, NotificationStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void update(String news) {
        strategy.send(news, name);
    }
}
