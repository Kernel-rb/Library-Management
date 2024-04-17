package src;
public class Admin extends User {    
    public Admin(String username){
        super(username);
    }
    public Admin(String username, String email, String phonenumber, String password){
        super(username, email, phonenumber, password);
    }

    @Override
    public void menu() {
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
    }
}
