public class NormalUser extends User {
    public NormalUser(String username){
        super(username);
    }
    public NormalUser(String username, String email, String phonenumber, String password){
        super(username, email, phonenumber, password);
    }

    @Override
    public void menu() {
        System.out.println("1.View Profile");
        System.out.println("2.Edit Profile");
        System.out.println("3.View Books");
        System.out.println("4.Place Order");
        System.out.println("5.Borrow Book");
        System.out.println("6.Calculate Fine");
        System.out.println("7.Return Book");
        System.out.println("8.Logout");
        System.out.println("9.Exit");
    }
}
