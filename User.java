import java.util.*;


public class User{
  
  private String name;
  private int age;
  private ArrayList<OwnedStock> portfolio;
  
  public User(String name, int age){
    this.name = name;
    this.age = age;
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
   this.name = name;
  }
  
  public int getAge(){
   return age; 
  }
  
  public void setAge(int age){
   this.age = age;
  }
  
  public ArrayList<OwnedStock> getPortfolio(){
   return portfolio; 
  }
  
  public void setPortfolio(ArrayList<OwnedStock> portfolio){
   this.portfolio = portfolio; 
  }
} 