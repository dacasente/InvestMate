/**
 * Auto Generated Java Class.
 */
import java.util.ArrayList;
public class UserManager {
  private ArrayList<User> users = new ArrayList<User>();
  
  public boolean addUser(String name, int age, String pw){
    if (users.size()==0){
      users.add(new User(name,age,pw));
      return true;
    }
    if (getUser(name)!=null){
      users.add(new User(name,age,pw));
      return true;
    }
    else{
      return false;
    }
  }
  
  public User getUser(String name){
    int i = 0;
    while (i <= users.size()){
      if (users.get(i).getName().equals(name)){
        return users.get(i);
      }else{
        i++;
      }
    }
    return null;
  }
  
  public boolean checkPassword(String pw){
    String pwl = pw.toLowerCase();
    String pwu = pw.toUpperCase();
    if (pwl.equals(pw)){
      return false;
    }
    if (pwu.equals(pw)){
      return false;
    }
    if (pw.length() <= 8){
      return false;
    }
    return true;
  }
 
}
