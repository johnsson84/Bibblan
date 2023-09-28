import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String firstName = " ";
    private String lastName = " ";
    private long personalNumber;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(String username ,String firstName, String lastName, long personalNumber) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        long length = String.valueOf(personalNumber).length();
        if (length != 12) {
            System.out.println("ERROR! Please enter 12 numbers for your personal number.");
        }
        else {
            this.personalNumber = personalNumber;
        }

    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void userInfo() {
        System.out.printf("|%-15s |%-15s |%-15s |%-20s %n", this.username, this.firstName, this.lastName, personalNumber);
    }


    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBook(Book book) {
        this.borrowedBooks.add(book);
    }

    public void removeBook(Book book) {
        this.borrowedBooks.remove(book);
    }

}
