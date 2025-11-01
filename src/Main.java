public class Main {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Subscriber user1 = new Subscriber("Aruzhan", new EmailNotification());
        Subscriber user2 = new Subscriber("Nurlan", new SMSNotification());
        Subscriber user3 = new Subscriber("Aliya", new PushNotification());

        agency.addObserver(user1);
        agency.addObserver(user2);
        agency.addObserver(user3);

        agency.publishArticle("Breaking News: New Tech Trends 2025");
        agency.publishArticle("Exclusive: AI Changes Everything!");

        // Меняем стратегию
        System.out.println("\n--- Nurlan changed notification method to Email ---");
        user2.setStrategy(new EmailNotification());

        agency.publishArticle("Update: SpaceX Launch Successful!");
    }
}
