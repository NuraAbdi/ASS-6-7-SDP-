import manager.UserManager;
import model.*;
import observer.NewsAgency;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();
        NewsAgency agency = new NewsAgency();

        System.out.println("=== News Portal ===");

        while (true) {
            System.out.println("\n1. Register  2. Login  3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();
                System.out.print("Notification type (email/sms/push): ");
                String type = sc.nextLine();

                if (userManager.registerUser(username, password, type))
                    System.out.println("✅ Registered successfully!");
                else
                    System.out.println("⚠️ Username already exists!");

            } else if (choice == 2) {
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();

                User user = userManager.login(username, password);
                if (user == null) {
                    System.out.println("❌ Invalid credentials!");
                    continue;
                }

                if (user instanceof Admin) {
                    System.out.println("👑 Welcome, Admin " + username);
                    while (true) {
                        System.out.print("\n1. Publish News  2. Logout\n> ");
                        int opt = sc.nextInt();
                        sc.nextLine();
                        if (opt == 1) {
                            System.out.print("Enter category: ");
                            String cat = sc.nextLine();
                            System.out.print("Enter content: ");
                            String text = sc.nextLine();
                            News n = NewsFactory.createNews(cat, text);
                            ((Admin) user).publish(agency, n);
                        } else break;
                    }
                } else {
                    System.out.println("👋 Welcome, " + username);
                    System.out.print("Subscribe to news? (y/n): ");
                    if (sc.nextLine().equalsIgnoreCase("y")) {
                        user.setSubscribed(true);
                        agency.register(user);
                        System.out.println("You are now subscribed!");
                    }
                }
            } else break;
        }
        sc.close();
    }
}
