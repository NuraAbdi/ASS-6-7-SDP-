package app;

import news.News;
import news.NewsAgency;
import users.Admin;
import users.User;
import users.UserManager;
import notifications.NotificationFactory;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserManager userManager = new UserManager();
    private static User currentUser = null;
    private static final NewsAgency agency = NewsAgency.getInstance();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMainMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    handleRegister();
                    break;
                case "2":
                    handleLogin();
                    break;
                case "3":
                    browseNews();
                    break;
                case "4":
                    addNews(); // доступно только admin
                    break;
                case "5":
                    showUsers();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exit. Bye!");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n*** NEWS PORTAL ***");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. News");
        System.out.println("4. Add news (admin)");
        System.out.println("5. Show users");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    private static void handleRegister() {
        System.out.print("Enter username: ");
        String u = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String p = scanner.nextLine().trim();
        System.out.print("Choose notification (email/sms/push): ");
        String strat = scanner.nextLine().trim();
        boolean ok = userManager.register(u, p, strat);
        if (ok) System.out.println("Registered " + u);
        else System.out.println("Username already taken.");
    }

    private static void handleLogin() {
        System.out.print("Username: ");
        String u = scanner.nextLine().trim();
        System.out.print("Password: ");
        String p = scanner.nextLine().trim();
        User user = userManager.login(u,p);
        if (user == null) {
            System.out.println("Login failed.");
            return;
        }

        //currentUser = user;
        //System.out.println("Logged in as " + currentUser.getUsername());
            // подпишем пользователя по умолчанию
        //if (!currentUser.isSubscribed()) {
        //    agency.register(currentUser);
        //    currentUser.setSubscribed(true);
        //}
        // меню пользователя

        userMenu();
    }

    private static void userMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- User Menu (" + currentUser.getUsername() + ") ---");
            System.out.println("1. View my info");
            System.out.println("2. Change notification type");
            System.out.println("3. Unsubscribe");
            System.out.println("4. Subscribe");
            System.out.println("5. Logout");
            System.out.print("Choice: ");
            String c = scanner.nextLine().trim();
            switch (c) {
                case "1":
                    System.out.println("Username: " + currentUser.getUsername());
                    System.out.println("Subscribed: " + currentUser.isSubscribed());
                    System.out.println("Notification type: " + currentUser.getNotificationStrategy().getClass().getSimpleName());
                    break;
                case "2":
                    System.out.print("Enter new notification (email/sms/push): ");
                    String newStr = scanner.nextLine().trim();
                    currentUser.setNotificationStrategy(NotificationFactory.create(newStr));
                    break;
                case "3":
                    agency.unregister(currentUser);
                    currentUser.setSubscribed(false);
                    break;
                case "4":
                    agency.register(currentUser);
                    currentUser.setSubscribed(true);
                    break;
                case "5":
                    currentUser = null;
                    back = true;
                    break;
                default:
                    System.out.println("Invalid.");
            }
        }
    }

    private static void browseNews() {
        List<News> list = agency.getNewsList();
        if (list.isEmpty()) {
            System.out.println("No news yet.");
            return;
        }
        System.out.println("\n!!! News !!!");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i).toString());
        }
    }

    private static void addNews() {
        // проверка: текущий пользователь должен быть админ, но т.к. addNews может вызываться из главного меню
        // сделаем запрос логина админа
        System.out.print("Admin username: ");
        String u = scanner.nextLine().trim();
        System.out.print("Admin password: ");
        String p = scanner.nextLine().trim();
        User user = userManager.login(u, p);
        if (user == null || !(user instanceof Admin)) {
            System.out.println("Only admin can add news.");
            return;
        }
        Admin admin = (Admin) user;
        System.out.print("Category: ");
        String category = scanner.nextLine().trim();
        System.out.print("Content: ");
        String content = scanner.nextLine().trim();
        admin.publish(category, content);
    }

    private static void showUsers() {
        System.out.print("Admin username: ");
        String u = scanner.nextLine().trim();
        System.out.print("Admin password: ");
        String p = scanner.nextLine().trim();
        User user = userManager.login(u, p);
        if (user == null || !(user instanceof Admin)) {
            System.out.println("Only admin can view users.");
            return;
        }
        System.out.println("** Registered users **");
        for (User us : userManager.getAll()) {
            System.out.println(" * " + us.getUsername() + " | subscribed: " + us.isSubscribed());
        }
    }
}
