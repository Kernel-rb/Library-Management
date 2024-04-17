public class Admin extends User {    
    public Admin(String username){
        super(username);
    }
    public Admin(String username, String email, String phonenumber, String password){
        super(username, email, phonenumber, password);
    }
}
