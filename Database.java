import java.util.Scanner;

public class Database {
  public public static void main(String[] args) {
    Sytem.out.println("Welcome to Library Management System ! \n  
                    1.Login \n
                    2.Sign up \n
        ");

    Scanner input = new Scanner(System.in);
    int choice  = input.nextInt();
    switch(choice){
      case 1 : login();
      case 2 : signUp();
      default : System.out.println("Choise 1 or 2 ");
    }
  }
}
