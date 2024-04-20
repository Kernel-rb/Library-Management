package src;

public class Exit implements Command {
    @Override 
    public void oper(Database database , User user){
        System.out.println("Add Book");
    }
}
