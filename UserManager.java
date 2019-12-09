import java.util.ArrayList;

public class UserManager {
  
  public static boolean addUser(String name, String pw, int age, Portfolio port){
    UserDatabase data = new UserDatabase();
    boolean add = data.addUser(name, pw, age, port);
    return add;
  }

  public static User getUser(String name){
    UserDatabase data = new UserDatabase();
    User output = data.getAUser(name);
    return output;
  }
  
  public static ArrayList<User> getUsers(){
	  UserDatabase data = new UserDatabase();
	  ArrayList<User> output = data.getUsers();
	  return output;
  }
  
  
  
  public static boolean checkUser (String name, String Ps) {
	  UserDatabase data = new UserDatabase();
	  ArrayList <User> users = data.getUsers();
	  for (int i = 0; i < users.size();i++) {
		  if (name.equals(users.get(i).getName()) || Ps.equals(users.get(i).getPassword()))
			  return true;
	  }
	  return false;
  }
  
  public static User Login (String name, String Ps) {
	  UserDatabase data = new UserDatabase();
	  return data.getAUser(name);
  }
  
  
  public static boolean updateName(String old, String newName) {
	  UserDatabase data = new UserDatabase();

	  boolean update = data.updateName(old, newName);
	  return update;
	  
	  
  }
  
  public static boolean updateAge(String name, int newAge) {
	  UserDatabase data = new UserDatabase();
	  
	  boolean update = data.updateAge(name, newAge);
	  
	  return update;
  }
  
  public static boolean updatePassword(String name, String newPassword) {
	  UserDatabase data = new UserDatabase();
	  
	  boolean update = data.updatePassword(name, newPassword);
	  
	  return update;
	  
  }
  
  public static boolean updatePortfolio(String name, Portfolio port) {
	  UserDatabase data = new UserDatabase();

	  boolean update = data.updatePortfolio(name, port);
	  
	  return update;
  }
  
 
}