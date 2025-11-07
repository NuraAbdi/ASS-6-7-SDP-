package strategy;

public class PushNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message) {
        System.out.println("Push notification sent: " + message);
    }
}
