import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
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

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    }
}