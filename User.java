public class User {
  protected String name;
  protected String nickname;
  protected String email;
  protected String phonenumber;

  // Constructor : 
  public User(String name , String nickname  , String email , String phonenumber){
    this.name = name;
    this.nickname = nickname;
    this.email = email;
    this.phonenumber = phonenumber;
  }

  // Getter methods : 
  public String getName(){
    return name;
  }
  public String getNickname() {
    return nickname;
  }

  public String getEmail(){
    return email;
  }

  public String getPhoneNumber(){
    return phonenumber;
  }


}
