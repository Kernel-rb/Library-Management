import java.util.Scanner;

public class Main {
  public static void main(String[] args){

    Database database = new Database();

        System.out.println("Welcome to Library Management System \n "
    + " 1 . Login \n "
    + " 2 . Register \n "
    + " 3 . Exit \n "
    );

    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();
    switch(choice){
      case 1 :
      login();
      break;
      case 2 :
      register();
      break;
      case 3 :
      System.exit(0);
      break;
      default:
      System.out.println("Invalid choice");
    }
    input.close(); 
  }

  private static void login(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your username");
    String username = input.nextLine();
    System.out.println("Enter your password");
    String password = input.nextLine();
    input.close(); 
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
      User Admin = new Admin(username, email, phonenumber, password);
    }else{
      User user = new User(username, email, phonenumber, password);
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
