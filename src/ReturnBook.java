package src;

public class ReturnBook implements Command{
    @Override
    public void oper(Database database , User user){
        System.out.println("Return Book");
    }   
}
