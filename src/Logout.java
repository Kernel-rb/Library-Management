package src;

public class Logout implements Command{
    @Override 
    public void oper(Database database , User user){
        System.out.println("------Logout-------");
        Logger.log("User " + user.getUsername() + " logged out");
        System.out.println("User " + user.getUsername() + " logged out");
    }
}
