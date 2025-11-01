public class SMSNotification implements NotificationStrategy {
    public void send(String message, String subscriberName) {
        System.out.println("📱 SMS to " + subscriberName + ": " + message);
    }
}