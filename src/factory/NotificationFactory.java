package factory;

import strategy.EmailNotification;
import strategy.SMSNotification;
import strategy.PushNotification;
import strategy.NotificationStrategy;

public class NotificationFactory {
    public static NotificationStrategy create(String type) {
        switch (type.toLowerCase()) {
            case "sms": return new SMSNotification();
            case "push": return new PushNotification();
            default: return new EmailNotification();
        }
    }
}
