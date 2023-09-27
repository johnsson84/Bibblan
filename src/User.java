public class User {
    private String firstName;
    private String lastName;
    private long personalNumber;

    public User(String firstName, String lastName, long personalNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        long length = String.valueOf(personalNumber).length();
        if (length != 12) {
            System.out.println("ERROR! Please enter 12 numbers for your personal number.");
        }
        else {
            this.personalNumber = personalNumber;
            System.out.println("User created!");
        }

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


}