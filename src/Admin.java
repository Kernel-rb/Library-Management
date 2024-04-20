package src;

import java.util.Scanner;

public class Admin extends User {

    public Admin(String username) {
        super(username);
        this.operation = new Command[]{
                new ViewProfile(),
                new EditProfile(),
                new ViewBooks(),
                new AddBook(),
                new RemoveBook(),
                new SearchBook(),
                new ViewOrders(),
                new BanUser(),
                new DeleteAccount(),
                new Logout(),
                new Exit()
        };
    }

    public Admin(String username, String email, String phonenumber, String password) {
        super(username, email, phonenumber, password);
        this.operation = new Command[]{
            new ViewProfile(),
            new EditProfile(),
            new ViewBooks(),
            new AddBook(),
            new RemoveBook(),
            new SearchBook(),
            new ViewOrders(),
            new BanUser(),
            new DeleteAccount(),
            new Logout(),
            new Exit()
        };
    }

    @Override
    public void menu() {
        try (Scanner input = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("1.View Profile");
                System.out.println("2.Edit Profile");
                System.out.println("3.View Books");
                System.out.println("4.Add Book");
                System.out.println("5.Remove Book");
                System.out.println("6.Search Book");
                System.out.println("7.View orders");
                System.out.println("8.Ban User");
                System.out.println("9.Delete Account");
                System.out.println("10.Logout");
                System.out.println("11.Exit");

                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                if (choice < 1 || choice > this.operation.length) {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + this.operation.length);
                } else {
                    this.operation[choice - 1].oper();
                }
            } while (choice != 11);
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
        }
    }
}
