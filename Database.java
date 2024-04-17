import java.util.ArrayList;

public class Database {
  ArrayList<User> users = new ArrayList<User>();
  ArrayList<String> usernames = new ArrayList<String>();

  public void addUser(User user){
    users.add(user);
    usernames.add(user.getUsername());
  }

  public int checkLogin(String username, String password){
    int successLogin = -1;
    for( User user : users){
      if(user.getUsername().equals(username) && user.getPassword().equals(password)){
        successLogin = 1;
        break;
      }
    }
    return successLogin;
  }

  public User getUser(int index){
    return users.get(index);
  }
}
