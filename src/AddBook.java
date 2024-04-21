package src;

import java.util.Scanner;

public class AddBook implements Command {
    @Override
    public void oper(Database database , User user){
        Scanner input = new Scanner(System.in);
        System.out.println("------Add Book-----");
        System.out.println("Enter Book Title: ");
        String title = input.nextLine();
        System.out.println("Enter Author: ");
        String author = input.nextLine();
        System.out.println("Enter Genre: ");
        String genre = input.nextLine();
        System.out.println("Enter Publisher: ");
        String publisher = input.nextLine();
        System.out.println("Enter Status: ");
        String status = input.nextLine();
        System.out.println("Enter Quantity: ");
        int quantity = input.nextInt();
        System.out.println("Enter Price: ");
        double price = input.nextDouble();
        System.out.println("Enter Barrow Copies: ");
        int barrowcopies = input.nextInt();

        Book book = new Book(title, author, genre, publisher, status, quantity, price, barrowcopies);
        
        if (database.addBook(book)) {
            System.out.println("\u001B[32mBook Added Successfully\u001B[0m"); // Green color for success
        } else {
            System.out.println("\u001B[31mFailed to Add Book\u001B[0m"); // Red color for failure
        }
        
        input.close();
    }
}