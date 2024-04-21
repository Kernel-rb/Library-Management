package src;

public class BanUser implements Command{
    @Override 
    public void oper(Database database , User user){
        System.out.println("------Ban User-------");
        Logger.log("User " + user.getUsername() + " banned");
        System.out.println("User " + user.getUsername() + " banned");
    }
}
