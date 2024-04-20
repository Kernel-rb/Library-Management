package src;


public abstract class  User {
  protected String username;
  protected String email;
  protected String phonenumber;
  protected String password;
  protected Command[] operation;

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

public String toString() {
    String userData = "Username: " + username + "\n" + "Email: " + email + "\n" + "Phone Number: " + phonenumber + "\n" + "Password: " + password.hashCode() + "\n";
    return userData;
} 

abstract public void menu(Database database, User user);
}
