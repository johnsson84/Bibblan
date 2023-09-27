import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> userlist = new ArrayList<>(10);



    public static void showListOfUsers() {
        for (User users : userlist) {
            users.userInfo();
        }
    }

    public static void createUser() {
        Scanner input = new Scanner(System.in);
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

        User user = new User(fName, lName, pNumber);
        userlist.add(user);

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                    break;
                case "2":
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
}