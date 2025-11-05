package notifications;

public class NotificationFactory {
    // Factory Method - создаёт стратегию по имени
    public static NotificationStrategy create(String type) {
        if (type == null) return new EmailNotification();
        switch (type.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                return new EmailNotification();
        }
    }
}
