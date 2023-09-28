import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<User> userlist = new ArrayList<>(10);
    static List<Book> booklist = new ArrayList<>(15);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        defaultBooks();
        User admin = new User("admin");
        User test = new User("test");
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
                    if (accessLevel == 0) System.out.println("Wrong username or user not found!");
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
    public static void listBorrowedBooks() {
        System.out.println("\nLIST OF BORROWED BOOKS");
        for (int i = 0; i < booklist.size(); i++) {
            if (!booklist.get(i).isAvailable) {
                System.out.println("\"" + booklist.get(i).getName() + "\"");
            }
        }
    }
    public static void defaultBooks() {
        Book book1 = new Book("Volodymyr Zelenskyj : i huvudet på en hjälte", "Régis Genté",
                "När Ryssland invaderade Ukraina klev Volodymyr Zelenskyj fram som en orädd ledare för sitt " +
                        "land och för kontinentens frihetskamp.");
        Book book2 = new Book("Bokälskare", "Emily Henry",
                "Hela Nora Stephens liv består av böcker. Som litterär agent i New York gör hon allt för sina " +
                        "författare, men också för sin älskade lillasyster Libby. Så när Libby ber Nora följa med till " +
                        "den idylliska småstaden Sunshine Falls i North Carolina ställer hon upp, om än motvilligt. " +
                        "Planen är att de ska ha en avkopplande systersemester tillsammans, samtidigt som Libby i " +
                        "hemlighet hoppas att Nora ska bli hjälte i sitt eget liv och inte bara i andras. Men i stället " +
                        "för picknickar i mysiga gläntor och heta möten med någon sexig skogshuggare eller snygg " +
                        "landsortsläkare, springer Nora ideligen på Charlie Lastra, en butter förläggare som också " +
                        "kommer från New York. Det skulle kanske ha kunnat bli gulligt och romantiskt, om det inte " +
                        "vore för det faktum att Nora och Charlie redan har träffats massor av gånger hemma i stan, " +
                        "och det har aldrig varit det minsta gulligt ... ");
        Book book3 = new Book("Barnsköterskan", "Stacey Halls", "West Yorkshire, 1904. " +
                "Nyutexaminerade barnsköterskan Ruby May tar en tjänst hos Charles och Lilian England, ett välbärgat " +
                "par med rötter i en dynasti av kvarnägare. Hon hoppas att det ska vara nystarten hon behöver. " +
                "Hon försöker göra sig hemmastadd i det isolerade huset Hardcastle, men märker ganska snart att " +
                "någonting inte är riktigt som det ska med den vackra, mystiska Mrs England. Utfryst av husets övriga " +
                "tjänare tvingas Ruby konfrontera sina egna demoner för att hindra att historien upprepar sig. Hon, " +
                "om någon, vet att något sådant som den perfekta familjen inte existerar. ");
        Book book4 = new Book("En enkel till Indien", "Cassandra Brunstedt", "Modejournalisten " +
                "Ella Franks största dröm blir verklighet när hon blir erbjuden jobbet som chefredaktör för den " +
                "skandinaviska utgåvan av världens största modemagasin. Men mitt i drömmen inser Ella att hon borde " +
                "varit försiktigare med vad hon önskat sig. Löftet om en ny och lycklig tillvaro med inflytande, " +
                "pengar och lyxiga champagnemingel visar sig snart ha varit för bra för att vara sant. Och en olycka " +
                "kommer sällan ensam. När Ellas liv rasar samman vet hon inte längre vad hon ska ta sig till. Utmattad " +
                "och besviken bokar hon en enkel biljett till Indien och checkar in på ett ashram. Där möter hon " +
                "meditationsläraren Amit som öppnar hennes ögon på fler sätt än hon trodde var möjligt. ");
        Book book5 = new Book("Kallmyren", "Liza Marklund", "I augusti 1990 gick Wiking Stormbergs " +
                "fru Helena ner sig i Kallmyren och drunknade. Kvar vid myrkanten låg deras baby, halvdöd av " +
                "insektsbett. Helenas kropp återfanns aldrig. Hon hördes aldrig mera av. Wiking kom aldrig över " +
                "förlusten av hustrun. Åren gick, decennierna. Han kom att leva för sina barn och sitt arbete som " +
                "polischef i Stenträsk. Men så en fredagseftermiddag landar ett brev i brevlådan hemma hos Markus, " +
                "Wikings och Helenas numera vuxne son. Ett hot, eller kanske en varning, skrivet med Helenas " +
                "handstil och undertecknat med hennes signatur: stjärnan som ser ut som ärret på hennes mage. " +
                "Wiking måste ställa sig frågan om han börjar bli galen, om han ser spöken eller om någon utomstående " +
                "kraft hotar honom och hans familj. ");
        booklist.add(book1);
        booklist.add(book2);
        booklist.add(book3);
        booklist.add(book4);
        booklist.add(book5);
        booklist.get(3).isAvailable = false;
    }

    public static void showListOfUsers() {
        String username = "Username";
        String fName = "First name";
        String lName = "Last name";
        String pNumber = "Personal number";
        System.out.printf("|%-15s |%-15s |%-15s |%-20s %n", username, fName, lName, pNumber);
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
        System.out.println("User created!");

    }

    public static int login() {
        Scanner input = new Scanner(System.in);
        int loginOK = 0;
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
                    break;
                }
            }
        }
        return loginOK;
    }

    public static void addBook() {
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
                    showListOfUsers();
                    break;
                case "2":
                    listBorrowedBooks();
                    break;
                case "3":
                    addBook();
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