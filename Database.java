import java.util.Scanner;

public class Database {
  public static void main(String[] args) {
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

    if(password.equals(password2)){
      System.out.println("Registration successful");
    }else{
      System.out.println("Passwords do not match");
    }

    System.out.println("1. Admin \n 2. User");
    int  typeofuser = input.nextInt();
    if(typeofuser == 1){
      System.out.println("Admin registration successful")
    }else{
      System.out.println("User registration successful")
    }
    input.close(); 
  }
}
