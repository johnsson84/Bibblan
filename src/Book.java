public class Book {
    private String name;
    private String author;
    private String shortInfo;
    boolean isAvailable = true;

    public Book(String name, String author, String shortInfo) {
        this.name = name;
        this.author = author;
        this.shortInfo = shortInfo;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getShortInfo() {
        return shortInfo;
    }
    public void bookInfo() {
        String name = "Name";
        String author = "Author";
        String info = "Info";
        System.out.println("##########################################################################################");
        System.out.printf("|%-60s |%-15s %n", name, author);
        System.out.printf("|%-60s |%-15s %n", this.name, this.author);
        System.out.printf("|%-15s %n", info);
        System.out.printf("|%-15s %n", this.shortInfo);
    }
}



