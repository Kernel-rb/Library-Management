package src;

public class BorrowBook implements Command {
    @Override
    public void oper(Database database , User user){
        System.out.println("Borrow Book");
    }
}
