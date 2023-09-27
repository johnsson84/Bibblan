import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> userlist = new ArrayList<>(10);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User admin = new User("admin");
        userlist.add(admin);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nBIBBLAN");
            System.out.println("1. Login" +
                             "\n2. Create new user" +
                             "\n3. Quit");
            System.out.print("Enter: ");
            String mainChoice = input.nextLine();
            switch (mainChoice) {
                case "1":
                    int accessLevel = login();
                    if (accessLevel == 2) adminMenu();
                    if (accessLevel == 1) ;
                    break;
                case "2":
                    createUser();
                    break;
                case "3":
                    isRunning = false;
                    break;
                default:
                    System.out.print("Wrong menu choice, try again: ");
                    break;
            }
        }
    }

    public static void showListOfUsers() {
        for (User users : userlist) {
            users.userInfo();
        }
    }

    public static void createUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter first name: ");
        String fName = input.nextLine();
        System.out.print("Enter last name: ");
        String lName = input.nextLine();

        System.out.print("Enter personal number (12 numbers): ");
        long pNumber = 0L;
        while (true) {
            try {
                pNumber = input.nextLong();
                break;
            }
            catch (InputMismatchException e) {
                System.out.print("Only numbers! Try again: ");
                input.nextLine();
            }
        }

        User user = new User(username, fName, lName, pNumber);
        userlist.add(user);

    }

    public static int login() {
        Scanner input = new Scanner(System.in);
        int loginOK = -1;
        System.out.print("Enter your username to login: ");
        String username = input.nextLine();
        if (username.equalsIgnoreCase("admin")) {
            System.out.print("Enter password: ");
            String password = input.nextLine();
            if (password.equals("admin123")) {
                loginOK = 2;
                System.out.println("Logged in as Admin");
            }
            else System.out.println("Wrong password!");
        }
        else {
            for (int i = 0; i < userlist.size(); i++) {
                if (username.equalsIgnoreCase(userlist.get(i).getUsername())) {
                    loginOK = 1;
                    System.out.println("Logged in as " + userlist.get(i).getUsername());
                }
                else {
                    loginOK = -1;
                    System.out.println("Wrong username or user not found!");
                }
            }
        }
        return loginOK;
    }

    public static void adminMenu() {
        Scanner input = new Scanner(System.in);
        boolean adminMenuRunning = true;
        while (adminMenuRunning) {
            System.out.println("\nADMIN MENU");
            System.out.println("1. List users" +
                    "\n2. List borrowed books" +
                    "\n3. Add a book" +
                    "\n4. Remove a book" +
                    "\n5. Return to main menu");
            System.out.print("Enter: ");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    adminMenuRunning = false;
                    break;
            }
        }
    }
}