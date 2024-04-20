package src;

public class Exit implements Command {

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
    
    @Override 
    public void oper(Database database , User user){
        Logger.log("Exiting the program");
        System.out.println(ANSI_GREEN + "Goodbye" + ANSI_RESET);
        System.exit(0);
    }
}
