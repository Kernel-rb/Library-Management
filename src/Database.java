package src;

import java.io.File;
import java.util.ArrayList;

public class Database {
  private ArrayList<User> users = new ArrayList<User>();
  private ArrayList<String> usernames = new ArrayList<String>();
  private ArrayList<Book> books = new ArrayList<Book>();
  private ArrayList<String> bookTitles = new ArrayList<String>();

  private File usersFile = new File(Main.class.getResource("\\Users").toExternalForm());
  private File booksFile = new File(Main.class.getResource("\\Books").toExternalForm());

  public Database(){
    if(!usersFile.exists()){
      usersFile.mkdirs();
    }
    if(!booksFile.exists()){
      booksFile.mkdirs();
    }
  }


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

  public void addBook(Book book){
    books.add(book);
    bookTitles.add(book.getTitle());
  }
}
