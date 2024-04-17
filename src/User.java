package src;
public abstract class  User {
  protected String username;
  protected String email;
  protected String phonenumber;
  protected String password;

  public User() {
  }
  public User(String username) {
      this.username = username;
  }
  public User(String username , String email, String phonenumber, String password) {
      this.username = username;
      this.email = email;
      this.phonenumber = phonenumber;
      this.password = password;
  }

  // Getter methods :
  public String getUsername() {
      return username;
  }

  public String getEmail() {
      return email;
  }

  public String getPhoneNumber() {
      return phonenumber;
  }

  public String getPassword() {
      return password;
  }


  abstract public void menu();
}
