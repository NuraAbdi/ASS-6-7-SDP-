package strategy;

public class NotificationFactory {
    public static NotificationStrategy create(String type) {
        if (type == null) return new EmailNotification();
        switch (type.toLowerCase()) {
            case "sms": return new SMSNotification();
            case "push": return new PushNotification();
            default: return new EmailNotification();
        }
    }
}
