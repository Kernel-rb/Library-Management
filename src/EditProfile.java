package src;

public class EditProfile implements Command {
    @Override 
    public void oper(Database database , User user){
        System.out.println("Edit Profile");

    }
}
