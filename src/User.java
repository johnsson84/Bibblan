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

    public void userInfo() {
        String fName = "First name";
        String lName = "Last name";
        String pNumber = "Personal number";
        System.out.printf("|%-15s |%-15s |%-20s %n", fName, lName, pNumber);
        System.out.printf("|%-15s |%-15s |%-20s %n", this.firstName, this.lastName, personalNumber);
    }


}
