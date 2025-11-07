import builder.UserBuilder;
import factory.NotificationFactory;
import model.User;
import observer.Publisher;

public class Main {
    public static void main(String[] args) {
        // === Factory + Builder ===
        User user1 = new UserBuilder()
                .setUsername("Nura")
                .setPassword("1234")
                .setStrategy(NotificationFactory.create("email"))
                .build();

        User user2 = new UserBuilder()
                .setUsername("Nari")
                .setPassword("5678")
                .setStrategy(NotificationFactory.create("sms"))
                .build();

        User user3 = new UserBuilder()
                .setUsername("Nurdau")
                .setPassword("abcd")
                .setStrategy(NotificationFactory.create("push"))
                .build();

        Publisher publisher = new Publisher();
        publisher.subscribe(user1);
        publisher.subscribe(user2);
        publisher.subscribe(user3);

        publisher.publishArticle("Breaking news: Major event!");
        publisher.publishArticle("Update: Details revealed.");
    }
}
