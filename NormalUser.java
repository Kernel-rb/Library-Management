public class NormalUser extends User {
    public NormalUser(String username){
        super(username);
    }
    public NormalUser(String username, String email, String phonenumber, String password){
        super(username, email, phonenumber, password);
    }
}
