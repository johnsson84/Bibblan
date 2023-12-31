import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<User> userlist = new ArrayList<>(10); // Lista med användare
    static List<Book> booklist = new ArrayList<>(15); // Lista med tillgängliga böcker
    static List<Book> borrowedBookList = new ArrayList<>(15); // Lista med lånade böcker
    static int currentUser = -1; // Anger vem som är aktiv från användarlistan

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        defaultBooks();
        User admin = new User("admin", "Admin", "Admin", 194544556677L); // Default admin konto
        User test = new User("test", "Test", "TEST", 157701010188L); // Test användare
        userlist.add(admin);
        userlist.add(test);
        boolean isRunning = true; // Anger att programmet körs
        while (isRunning) {
            // Main menu
            System.out.println("\nBIBBLAN");
            System.out.println("1. Login" +
                             "\n2. Create new user" +
                             "\n3. Quit");
            System.out.print("Enter: ");
            String mainChoice = input.nextLine();
            switch (mainChoice) {
                case "1":
                    int accessLevel = login(); // kör login metoden och beroende på accesslevel så körs fler metoder under
                    if (accessLevel == 2) adminMenu();
                    if (accessLevel == 1) userMenu();
                    if (accessLevel == 0) System.out.println("Wrong username or user not found!");
                    break;
                case "2":
                    createUser(); // Kör skapa användare metoden
                    break;
                case "3":
                    isRunning = false; // Avslutar programmet
                    break;
                default:
                    System.out.print("Wrong menu choice, try again: ");
                    break;
            }
        }
    }
    public static void listBorrowedBooks() {
        // Loopar igenom lsitan med lånade böcker
        System.out.println("\nLIST OF BORROWED BOOKS");
        for (int i = 0; i < borrowedBookList.size(); i++) {
            System.out.println((i+1) + ". \"" + borrowedBookList.get(i).getName() + "\"");
        }
    }
    public static void listAllBooks() {
        // Loopar igenom båda listor och visar alla böcker
        System.out.println("\nLIST OF ALL BOOKS");
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println("\"" + booklist.get(i).getName() + "\"");
        }
        for (int i = 0; i < borrowedBookList.size(); i++) {
            System.out.println("\"" + borrowedBookList.get(i).getName() + "\"");
        }
    }
    public static void listAvailableBooks() {
        // Loopar listan med tillgängliga böcker
        System.out.println("\nLIST OF BORROWED BOOKS");
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println((i+1) + ". \"" + booklist.get(i).getName() + "\"");
        }
    }
    public static void defaultBooks() {
        // En metod som lägger till några default böcker
        Book book1 = new Book("Volodymyr Zelenskyj : i huvudet på en hjälte", "Régis Genté",
                "När Ryssland invaderade Ukraina klev Volodymyr Zelenskyj fram som en orädd ledare för sitt\n " +
                        "land och för kontinentens frihetskamp.");
        Book book2 = new Book("Bokälskare", "Emily Henry",
                "Hela Nora Stephens liv består av böcker. Som litterär agent i New York gör hon allt för sina\n " +
                        "författare, men också för sin älskade lillasyster Libby. Så när Libby ber Nora följa med\n till " +
                        "den idylliska småstaden Sunshine Falls i North Carolina ställer hon upp, om än motvilligt.\n " +
                        "Planen är att de ska ha en avkopplande systersemester tillsammans, samtidigt som Libby i\n " +
                        "hemlighet hoppas att Nora ska bli hjälte i sitt eget liv och inte bara i andras. Men i\n stället " +
                        "för picknickar i mysiga gläntor och heta möten med någon sexig skogshuggare eller snygg\n " +
                        "landsortsläkare, springer Nora ideligen på Charlie Lastra, en butter förläggare som också\n " +
                        "kommer från New York. Det skulle kanske ha kunnat bli gulligt och romantiskt, om det inte\n " +
                        "vore för det faktum att Nora och Charlie redan har träffats massor av gånger hemma i stan,\n " +
                        "och det har aldrig varit det minsta gulligt ... ");
        Book book3 = new Book("Barnsköterskan", "Stacey Halls", "West Yorkshire, 1904.\n " +
                "Nyutexaminerade barnsköterskan Ruby May tar en tjänst hos Charles och Lilian England, ett välbärgat\n " +
                "par med rötter i en dynasti av kvarnägare. Hon hoppas att det ska vara nystarten hon behöver.\n " +
                "Hon försöker göra sig hemmastadd i det isolerade huset Hardcastle, men märker ganska snart att\n " +
                "någonting inte är riktigt som det ska med den vackra, mystiska Mrs England. Utfryst av husets\n övriga " +
                "tjänare tvingas Ruby konfrontera sina egna demoner för att hindra att historien upprepar sig.\n Hon, " +
                "om någon, vet att något sådant som den perfekta familjen inte existerar.\n ");
        Book book4 = new Book("En enkel till Indien", "Cassandra Brunstedt", "Modejournalisten\n " +
                "Ella Franks största dröm blir verklighet när hon blir erbjuden jobbet som chefredaktör för den\n " +
                "skandinaviska utgåvan av världens största modemagasin. Men mitt i drömmen inser Ella att hon borde\n " +
                "varit försiktigare med vad hon önskat sig. Löftet om en ny och lycklig tillvaro med inflytande,\n " +
                "pengar och lyxiga champagnemingel visar sig snart ha varit för bra för att vara sant. Och en olycka\n " +
                "kommer sällan ensam. När Ellas liv rasar samman vet hon inte längre vad hon ska ta sig till. Utmattad\n " +
                "och besviken bokar hon en enkel biljett till Indien och checkar in på ett ashram. Där möter hon\n " +
                "meditationsläraren Amit som öppnar hennes ögon på fler sätt än hon trodde var möjligt.\n ");
        Book book5 = new Book("Kallmyren", "Liza Marklund", "I augusti 1990 gick Wiking Stormbergs\n " +
                "fru Helena ner sig i Kallmyren och drunknade. Kvar vid myrkanten låg deras baby, halvdöd av\n " +
                "insektsbett. Helenas kropp återfanns aldrig. Hon hördes aldrig mera av. Wiking kom aldrig över\n " +
                "förlusten av hustrun. Åren gick, decennierna. Han kom att leva för sina barn och sitt arbete som\n " +
                "polischef i Stenträsk. Men så en fredagseftermiddag landar ett brev i brevlådan hemma hos Markus,\n " +
                "Wikings och Helenas numera vuxne son. Ett hot, eller kanske en varning, skrivet med Helenas\n " +
                "handstil och undertecknat med hennes signatur: stjärnan som ser ut som ärret på hennes mage.\n " +
                "Wiking måste ställa sig frågan om han börjar bli galen, om han ser spöken eller om någon\n utomstående " +
                "kraft hotar honom och hans familj. ");
        booklist.add(book1);
        booklist.add(book2);
        borrowedBookList.add(book3);
        booklist.add(book4);
        booklist.add(book5);
        // booklist.get(3).isAvailable = false; // isAvailable används inte i programmet som tänkt.
    }

    public static void showListOfUsers() {
        // Visar en lista över alla användare
        String username = "Username";
        String fName = "First name";
        String lName = "Last name";
        String pNumber = "Personal number";
        String line15 = "---------------";
        String line20 = "--------------------;";
        System.out.printf("|%-15s |%-15s |%-15s |%-20s %n", username, fName, lName, pNumber);
        System.out.printf("|%-15s |%-15s |%-15s |%-20s %n", line15, line15, line15, line20);
        for (User users : userlist) {
            users.userInfo();
        }
    }

    public static void createUser() {
        // Skapa en användare
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter first name: ");
        String fName = input.nextLine();
        System.out.print("Enter last name: ");
        String lName = input.nextLine();

        // För att spara ett 12 siffrigt personnummer måste long användas
        System.out.print("Enter personal number (12 numbers): ");
        long pNumber = 0L;
        while (true) {
            try {
                pNumber = input.nextLong();
                int antalSiffror = String.valueOf(pNumber).length();
                if (antalSiffror == 12) break;
                else System.out.print("Please enter 12 numbers, try again: ");
            }
            catch (InputMismatchException e) {
                System.out.print("Only numbers! Try again: ");
                input.nextLine();
            }
        }

        User user = new User(username, fName, lName, pNumber);
        userlist.add(user);
        System.out.println("User created!");

    }

    public static int login() {
        /*
        Login metod. Här returneras ett nummer som anger accesslevel.
        0 = fel eller ingen användare
        1 = vanlig användare
        2 = admin
         */
        Scanner input = new Scanner(System.in);
        int loginOK = 0;
        System.out.print("Enter your username to login: ");
        String username = input.nextLine();
        // Om man matar in admin får man även ange ett lösenord
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
            // Loopar igenom user listan och kollar om det inmatade användarnamnet finns
            for (int i = 0; i < userlist.size(); i++) {
                if (username.equalsIgnoreCase(userlist.get(i).getUsername())) {
                    loginOK = 1;
                    System.out.println("Logged in as " + userlist.get(i).getUsername());
                    currentUser = i;
                    break;
                }
            }
        }
        return loginOK;
    }

    public static void addBook() {
        // Lägg till en bok
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book name: ");
        String bookName = input.nextLine();;
        System.out.print("Enter author: ");
        String bookAuthor = input.nextLine();
        System.out.println("Enter a short description: ");
        String bookDescription = input.nextLine();
        Book addBook = new Book(bookName, bookAuthor, bookDescription);
        booklist.add(addBook);
        System.out.println("Book added!");
    }

    public static void removeBook() {
        // Ta bort en bok
        Scanner input = new Scanner(System.in);
        if (!booklist.isEmpty()) { // Kolla först att listan är tom
            System.out.println("Enter number of the book to remove (0 to cancel): ");
            int nr = pickNumber(); // Kör pickNumber metoden
            if (nr > 0) {
                System.out.println("Book \"" + booklist.get(nr-1).getName() + "\" removed from the collection!");
                booklist.remove((nr - 1));
            }
        }
        else System.out.println("List is empty!");
    }

    public static void adminMenu() {
        // Admin menyn
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
                    showListOfUsers();
                    break;
                case "2":
                    listBorrowedBooks();
                    break;
                case "3":
                    addBook();
                    break;
                case "4":
                    listAvailableBooks();
                    removeBook();
                    break;
                case "5":
                    adminMenuRunning = false; // Hoppa tillbaka till huvudmenyn
                    break;
                default:
                    System.out.println("Wrong menu choice, try again");
            }
        }
    }

    public static int pickNumber() {
        // Metod för att returnera en siffra som används för att välja en bok i någon lista
        Scanner input = new Scanner(System.in);
        int nr = 0;
        while (true) {
            try {
                nr = input.nextInt();
                if (nr >= 0) {
                    break;
                }
                else System.out.print("Number cant be negative! Try again: ");
            } catch (InputMismatchException e) {
                System.out.print("Only numbers! Try again: ");
                input.nextLine();
            }
        }
        return nr;
    }

    public static void borrowBook() {
        // Låna en bok
        System.out.println("Do you want to borrow a book?");
        System.out.print("Enter book number or 0 to cancel: ");
        int nr = pickNumber();
        if (nr > 0) {
            try {
                System.out.println("Book \"" + booklist.get(nr-1).getName() + "\" borrowed from the collection!");
                System.out.println("Please remember to return the book within 2 weeks.");
                borrowedBookList.add(booklist.get((nr - 1))); // Lägger till boken i lånade böcker listan
                userlist.get(currentUser).addBook(booklist.get((nr - 1))); // Lägger till boken i den aktuella användarens boklista
                booklist.remove((nr - 1)); // Tar bort boken från huvudlistan
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid choice");
            }
        }
    }

    public static void showBookInfo() {
        // Visar bok info om varje bok som finns tillgänglig, se mer om bookInfo() i bok klassen
        for (int i = 0; i < booklist.size(); i++) {
            booklist.get(i).bookInfo();
        }
    }

    public static void showBorrowedBooks() {
        // Visar lånade böcker från den inloggade usern
        System.out.println("Your borrowed books");
        for (int i = 0; i < userlist.get(currentUser).getBorrowedBooks().size(); i++) {
            System.out.println((i+1) + ". " + userlist.get(currentUser).getBorrowedBooks().get(i).getName());
        }
    }

    public static void returnBook() {
        // Den svåraste metoden, knappt jag fick ihop det här...
        if (!userlist.get(currentUser).getBorrowedBooks().isEmpty()) {
            showBorrowedBooks();
            System.out.print("Enter the book you want to return (0 to cancel): ");
            int nr = pickNumber();
            if (nr > 0) {
                nr -= 1;
                try {
                    String bookName = userlist.get(currentUser).getBorrowedBooks().get(nr).getName();
                    booklist.add(userlist.get(currentUser).getBorrowedBooks().get(nr));
                    for (int i = 0; i < userlist.get(currentUser).getBorrowedBooks().size(); i++) {
                        if (bookName.equals(userlist.get(currentUser).getBorrowedBooks().get(i).getName())) {
                            userlist.get(currentUser).removeBook(userlist.get(currentUser).getBorrowedBooks().get(i));
                        }
                    }
                    for (int i = 0; i < borrowedBookList.size(); i++) {
                        if (bookName.equals(borrowedBookList.get(i).getName())) {
                            borrowedBookList.remove(borrowedBookList.get(i));
                        }
                    }
                    System.out.println("Book returned!");
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid choice");
                }


            }
        }
        else System.out.println("You have not borrowed any books.");
    }

    public static void userMenu() {
        // Användar menyn
        Scanner input = new Scanner(System.in);
        boolean userMenuRunning = true;
        while (userMenuRunning) {
            System.out.println("\nUSER MENU");
            System.out.println("1. List all books" +
                    "\n2. Borrow books" +
                    "\n3. Book info" +
                    "\n4. List books you borrowed" +
                    "\n5. Return a book" +
                    "\n6. Return to main menu");
            System.out.print("Enter: ");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    listAllBooks();
                    break;
                case "2":
                    listAvailableBooks();
                    borrowBook();
                    break;
                case "3":
                    showBookInfo();
                    break;
                case "4":
                    showBorrowedBooks();
                    break;
                case "5":
                    returnBook();
                    break;
                case "6":
                    userMenuRunning = false;
                    break;
                default:
                    System.out.println("Wrong menu choice, try again");
                    break;
            }
        }
    }
}