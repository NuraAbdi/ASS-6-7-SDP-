public class PushNotification implements NotificationStrategy {
    public void send(String message, String subscriberName) {
        System.out.println("🔔 Push notification to " + subscriberName + ": " + message);
    }
}