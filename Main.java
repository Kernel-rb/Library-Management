import java.util.Scanner;

public class Main {
  static Database database;
  public static void main(String[] args){

    database = new Database();
    int choice; 
    do{
      
      System.out.println("Welcome to Library Management System \n" + 
      "1. Login \n" +
      "2. Register \n" +
      "0. Exit \n" +
      ""
      );

      Scanner input = new Scanner(System.in);
      choice = input.nextInt();
      switch(choice){
        case 1:
          login();
          break;
        case 2:
          register();
          break;
        case 0:
          System.out.println("Goodbye");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
    } while(choice != 0);


  }

  private static void login(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your username");
    String username = input.nextLine();
    System.out.println("Enter your password");
    String password = input.nextLine();
    int loginStatus = database.checkLogin(username, password);
    if(loginStatus == 1){
      User user = database.getUser(loginStatus);
      System.out.println("Welcome " + user.getUsername());
    }else{
      System.out.println("Invalid username or password");
    };
  }

  private static void register(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your username");
    String username = input.nextLine();
    System.out.println("Enter your phone number");
    String phonenumber = input.nextLine();
    System.out.println("Enter your email");
    String email = input.nextLine();
    System.out.println("Enter your password");
    String password = input.nextLine();
    System.out.println("Enter your password again");
    String password2 = input.nextLine();
    checkPassword(password, password2);
  
    System.out.println("1. Admin \n 2. User");
    int  typeofuser = input.nextInt();
    if(typeofuser == 1){
      User admin =  new Admin(username, email, phonenumber, password);
      database.addUser(admin);
    }else{
      User user = new User(username, email, phonenumber, password);
      database.addUser(user);
    }
    input.close();
  }

  private static void checkPassword(String password, String password2){
    if(password.equals(password2)){
      System.out.println("Registration successful");
    }else{
      System.out.println("Passwords do not match");
    }

    if(password.length() < 8){
      System.out.println("Password must be at least 8 characters long");
    }
    if (password.matches("[a-zA-Z0-9]*")){
      System.out.println("Password must contain at least one special character");
    }

  }

}
