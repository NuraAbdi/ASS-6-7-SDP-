public class EmailNotification implements NotificationStrategy {
    public void send(String message, String subscriberName) {
        System.out.println("📧 Email to " + subscriberName + ": " + message);
    }
}