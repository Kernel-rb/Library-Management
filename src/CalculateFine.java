package src;

public class CalculateFine implements Command{
    @Override
    public void oper(Database database , User user){
        System.out.println("Calculate Fine");
    }
}
