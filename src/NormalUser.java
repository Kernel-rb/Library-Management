package src;

import java.util.Scanner;

public class NormalUser extends User {

    public NormalUser(String username) {
        super(username);
        this.operation = new Command[]{
            new ViewProfile(),
            new EditProfile(),
            new ViewBooks(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Logout(),
            new Exit()
        };
    }

    public NormalUser(String username, String email, String phonenumber, String password) {
        super(username, email, phonenumber, password);
        this.operation = new Command[]{
            new ViewProfile(),
            new EditProfile(),
            new ViewBooks(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Logout(),
            new Exit()
        };
    }

    @Override
    public void menu(Database database , User user) {
        try (Scanner input = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("1.View Profile");
                System.out.println("2.Edit Profile");
                System.out.println("3.View Books");
                System.out.println("4.Place Order");
                System.out.println("5.Borrow Book");
                System.out.println("6.Calculate Fine");
                System.out.println("7.Return Book");
                System.out.println("8.Logout");
                System.out.println("9.Exit");

                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                if (choice < 1 || choice > this.operation.length) {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + this.operation.length);
                } else {
                    this.operation[choice - 1].oper(database, user);
                }
            } while (choice != 9);
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
    }

    public String toString() {
        String userData = "Username: " + username + "\n" + "Email: " + email + "\n" + "Phone Number: " + phonenumber + "\n" + "Password: " + password.hashCode() + "\n" + "Role: Normal" + "\n";
        return userData;
    }
}
