import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static Database database;
    static Scanner input;
    static boolean loggedIn = false;

    // !bach nchanger les colr dyal output 
    public static final String ANSI_CUSTOM = "\u001B[38;5;208m"; // Orange 
    public static final String ANSI_RESET = "\u001B[0m"; // RESET
    public static final String ANSI_RED = "\u001B[31m"; // RED
    public static final String ANSI_GREEN = "\u001B[32m"; // GREEN

    public static void main(String[] args) {
        database = new Database();
        input = new Scanner(System.in);
        String version = getVersionFromFile("version.txt"); 

        int choice;
        do {
            if (!loggedIn) {
                System.out.println("**********************************************");
                System.out.println("*  " + ANSI_CUSTOM + "Welcome to the Library Management System" + ANSI_RESET + "  *");
                System.out.println("*            Version: " + ANSI_CUSTOM + version + ANSI_RESET + "                  *");
                System.out.println("*         Author: " + ANSI_CUSTOM + "Kernel.rb" + ANSI_RESET + "                  *");
                System.out.println("**********************************************");
                System.out.println("1. Login");
                System.out.println("2. Register");  
                System.out.println("3. Exit");
                System.out.println("");
            }

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println(ANSI_GREEN + "Goodbye" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid choice" + ANSI_RESET);
                    break;
            }
        } while (choice != 3);

        input.close(); 
    }

    private static String getVersionFromFile(String filename) {
      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
          return br.readLine();
      } catch (IOException e) {
          e.printStackTrace();
          return "Could not read version from file."; 
      }
  }

    private static void login() {
        input.nextLine(); 
        System.out.println("Enter your username:");
        String username = input.nextLine();
        System.out.println("Enter your password:");
        String password = input.nextLine();
        int loginStatus = database.checkLogin(username, password);
        if (loginStatus == 1) {
            User user = database.getUser(loginStatus);
            System.out.println(ANSI_GREEN + "Welcome, " + user.getUsername() + "!" + ANSI_RESET);
            user.menu();
            loggedIn = true; // Set the flag to true after successful login
        } else {
            System.out.println(ANSI_RED + "Invalid username or password." + ANSI_RESET);
            System.exit(0);
        }
    }

    private static void register() {
        input.nextLine(); 
        System.out.println("Enter your username:");
        String username = input.nextLine();
        System.out.println("Enter your phone number:");
        String phoneNumber = input.nextLine();
        System.out.println("Enter your email:");
        String email = input.nextLine();
        String password;
        String password2;
        do {
            System.out.println("Enter your password:");
            password = input.nextLine();
            System.out.println("Enter your password again:");
            password2 = input.nextLine();
            if (!checkPassword(password, password2)) {
                System.out.println(ANSI_RED + "Passwords do not match or don't meet requirements." + ANSI_RESET);
            }
        } while (!checkPassword(password, password2));

        System.out.println("1. Admin \n2. User");
        int userType = input.nextInt();
        User user;
        if (userType == 1) {
            user  = new Admin(username, email, phoneNumber, password);
            database.addUser(user);
            System.out.println(ANSI_GREEN + "Registration successful!" + ANSI_RESET);
        } else {
            user = new NormalUser(username, email, phoneNumber, password);
            database.addUser(user);
            System.out.println(ANSI_GREEN + "Registration successful!" + ANSI_RESET);
        }
        user.menu();
        loggedIn = true; 
    }

    private static boolean checkPassword(String password, String password2) {
        if (!password.equals(password2)) {
            return false;
        }

        if (password.length() < 8) {
            System.out.println(ANSI_RED + "Password must be at least 8 characters long." + ANSI_RESET);
            return false;
        }
        
        if (!password.matches(".*[!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*")) {
            System.out.println(ANSI_RED + "Password must contain at least one special character." + ANSI_RESET);
            return false;
        }
        return true;
    }
}
