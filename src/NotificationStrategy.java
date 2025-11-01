public interface NotificationStrategy {
    void send(String message, String subscriberName);
}