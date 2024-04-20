package src;

public class ViewProfile implements Command {
    @Override 
    public void oper(Database database , User user){
        System.out.println("---View Profile---");
    }
}
