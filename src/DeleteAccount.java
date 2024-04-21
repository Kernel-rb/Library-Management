package src;

import java.util.Scanner;

public class DeleteAccount implements Command {
    @Override 
    public void oper(Database database , User user){
        System.out.println("------Delete Account-------");
        System.out.println("Are you sure you want to delete your account?");
        Logger.log("Are you sure you want to delete your account?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            if (database.deleteUser(user)) {
                Logger.log("Account Deleted Successfully");
                System.out.println("\u001B[32mAccount Deleted Successfully\u001B[0m"); 
            } else {
                Logger.log("Failed to Delete Account");
                System.out.println("\u001B[31mFailed to Delete Account\u001B[0m"); 
            }
        }
        input.close();
    }
}
