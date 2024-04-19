    package src;

    import java.util.Scanner;
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;

    public class Main {
        static Database database;
        static Scanner input;
        static boolean loggedIn = false;

        // Colors dyal Output
        public static final String ANSI_CUSTOM = "\u001B[38;5;208m"; // Orange 
        public static final String ANSI_RESET = "\u001B[0m"; // RESET
        public static final String ANSI_RED = "\u001B[31m"; // RED
        public static final String ANSI_GREEN = "\u001B[32m"; // GREEN
        public static final String ANSI_BLUE = "\u001B[34m"; // BLUE

        // Import Logger
        static Logger logger = new Logger();

        public static void main(String[] args) {
            database = new Database();
            input = new Scanner(System.in);
            String version = getVersionFromFile("version.txt"); 

            int choice = 0 ;
            do {
                if (!loggedIn) {
                    Logger.log("Welcome to the Library Management System");
                    Logger.log("Version: " + version);
                    Logger.log("Author: Kernel.rb");

                    System.out.println("**********************************************");
                    System.out.println("*  " + ANSI_CUSTOM + "Welcome to the Library Management System" + ANSI_RESET + "  *");
                    System.out.println("*            Version: " + ANSI_CUSTOM + version + ANSI_RESET + "                  *");
                    System.out.println("*         Author: " + ANSI_CUSTOM + "Kernel.rb" + ANSI_RESET + "                  *");
                    System.out.println("**********************************************");
                    System.out.println("1. Login");
                    System.out.println("2. Register");  
                    System.out.println("3. Exit");
                    System.out.println("4. Info about the program");  
                    System.out.println("");
                }

                try {
                    choice = input.nextInt();
                } catch(Exception e) {
                    Logger.log("You must enter a number [1-4]");
                    System.out.println(ANSI_RED + "Invalid choice" + ANSI_RESET);
                    input.nextLine();
                    continue;
                }
                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        register();
                        break;
                    case 3:
                        Logger.log("Exiting the program");
                        System.out.println(ANSI_GREEN + "Goodbye" + ANSI_RESET);
                        break;
                    case 4:
                        about();
                        break;
                    default:
                        Logger.log("Invalid choice entered");
                        System.out.println(ANSI_RED + "Invalid choice" + ANSI_RESET);
                        break;
                }
            } while (choice != 3);

            input.close(); 
        }

        // Version method
        private static String getVersionFromFile(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                return br.readLine();
            } catch (IOException e) {
                Logger.log("Failed to read version from file: " + e.getMessage());
                return "Could not read version from file."; 
            }
        }
        
        // Login method
        private static void login() {
            input.nextLine(); 
            System.out.println("Enter your username:");
            String username = input.nextLine();
            checkIfInputEqualToExit(username);
            System.out.println("Enter your password:");
            String password = input.nextLine();
            checkIfInputEqualToExit(password);
            int loginStatus = database.checkLogin(username, password);
            if (loginStatus == 1) { 
                User user = database.getUser(loginStatus);
                System.out.println(ANSI_GREEN + "Welcome, " + user.getUsername() + "!" + ANSI_RESET);
                user.menu();
                loggedIn = true; 
            } else {
                Logger.log("Invalid login attempt for user: " + username);
                System.out.println(ANSI_RED + "Invalid username or password." + ANSI_RESET);
                System.exit(0);
            }
        }
        
        // Register method
        private static void register() {
            input.nextLine(); 
            String username;
            String phoneNumber; 
            String email;
            String password;
            String password2;
            do {
                System.out.println("Enter your username (type 'exit' to cancel):");
                username = input.nextLine();
                if (username.equalsIgnoreCase("exit")) {
                    Logger.log("Registration canceled");
                    System.out.println(ANSI_GREEN + "Registration canceled. Goodbye." + ANSI_RESET);
                    System.exit(0);
                    return;
                }
                if (!checkUserName(username)) {
                    Logger.log("Invalid username entered during registration");
                    System.out.println(ANSI_RED + "Invalid username." + ANSI_RESET);
                }
            } while (!checkUserName(username));

            do {
                System.out.println("Enter your phone number:");
                phoneNumber = input.nextLine();
                checkIfInputEqualToExit(phoneNumber);
                if (!checkPhoneNumber(phoneNumber)) {
                    Logger.log("Invalid phone number entered during registration");
                    System.out.println(ANSI_RED + "Invalid phone number." + ANSI_RESET);
                }
            } while (!checkPhoneNumber(phoneNumber));
            
            do {
                System.out.println("Enter your email:");
                email = input.nextLine();
                checkIfInputEqualToExit(email);
                if (!checkEmail(email)) {
                    Logger.log("Invalid email entered during registration");
                    System.out.println(ANSI_RED + "Invalid email." + ANSI_RESET);
                }
            } while (!checkEmail(email));

            do {
                System.out.println("Enter your password:");
                password = input.nextLine();
                checkIfInputEqualToExit(password);
                System.out.println("Enter your password again:");
                password2 = input.nextLine();
                checkIfInputEqualToExit(password2);
                if (!checkPassword(password, password2)) {
                    Logger.log("Passwords do not match or don't meet requirements during registration");
                    System.out.println(ANSI_RED + "Passwords do not match or don't meet requirements." + ANSI_RESET);
                }
            } while (!checkPassword(password, password2));

            System.out.println("1. Admin \n2. User");
            int userType = input.nextInt();
            User user;
            if (userType == 1) {
                user  = new Admin(username, email, phoneNumber, password);
                database.addUser(user);
                Logger.log("Admin registered: " + username);
                System.out.println(ANSI_GREEN + "Registration successful!" + ANSI_RESET);
            } else {
                user = new NormalUser(username, email, phoneNumber, password);
                database.addUser(user);
                Logger.log("User registered: " + username);
                System.out.println(ANSI_GREEN + "Registration successful!" + ANSI_RESET);
            }
            user.menu();
            loggedIn = true; 
        }
        
        // About method
        private static void about() {
            Logger.log("Showing program information");
            System.out.println(ANSI_BLUE + "This program is a library management system.");
            System.out.println("It allows users to borrow and return books.");
            System.out.println("It also allows admins to add, remove, and edit books.");
            System.out.println("It was created by Kernel.rb.");
            System.out.println("Version: 0.0.1" + ANSI_RESET); 
            System.exit(0);
        }

        // Array of forbidden usernames
        static {
            ArrayList<String> forbiddenNames = new ArrayList<String>();
            forbiddenNames.add("admin");
            forbiddenNames.add("root");
            forbiddenNames.add("superuser");
            forbiddenNames.add("user");
            forbiddenNames.add("username");
            forbiddenNames.add("login");
            forbiddenNames.add("register");
        }
        private static ArrayList<String> forbiddenNames = new ArrayList<String>();
        static {
            forbiddenNames.add("admin");
            forbiddenNames.add("root");
            forbiddenNames.add("superuser");
            forbiddenNames.add("user");
            forbiddenNames.add("username");
            forbiddenNames.add("login");
            forbiddenNames.add("register");
        }
        
        // Check username method
        private static boolean checkUserName(String username) {
            if(username.length() < 3) {
                System.out.println(ANSI_RED + "Username must be at least 3 characters long." + ANSI_RESET);
                return false;
            }
            if (forbiddenNames.contains(username)) {
                System.out.println(ANSI_RED + "Username is not allowed." + ANSI_RESET);
                return false;
            }
            return true;
        }
        
        // Check phone number method
        private static boolean checkPhoneNumber(String phoneNumber) {
            if(phoneNumber.length() > 10) {
                return false;
            }
            if(!phoneNumber.matches("[0-9]+")) {
                return false;
            }
            return true;
        }

        // Check email method
        private static boolean checkEmail(String email) {
            if(email.contains("@") && email.contains(".")) {
                return true;
            }
            if(email.length() < 5) {
                return false;
            }
            if(email.matches(".*[!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*")) {
                return false; 
            }
            return false;
        }

        // Check password method
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

        // Check if input is equal to exit
        private static void checkIfInputEqualToExit(String input) {
            if(input.equals("exit")) {
                Logger.log("Exiting the program");
                System.out.println(ANSI_GREEN + "Goodbye" + ANSI_RESET);
                System.exit(0);
            }
        }
    }
