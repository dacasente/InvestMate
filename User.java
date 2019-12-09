import java.util.*;
import java.io.*;


public class User{
  
  private String name;
  private int age;
  private Portfolio portfolio;
  private String password;
  
  public User(String name, int age, String password){
    this.name = name;
    this.age = age;
    this.password = password;
  }
  
  public String getPassword() {
	  return password;
  }
  public void setPassword(String temp) {
	  this.password = temp;
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
  
  public Portfolio getPortfolio(){
   return portfolio; 
  }
  
  public void setPortfolio(Portfolio portfolio){
    this.portfolio = portfolio; 
  }
  
  
  public void createPortfolio(ArrayList<OwnedStock> input){
   Portfolio temp = new Portfolio(input);
   this.portfolio = temp; 
  }
  
  public boolean savePortfolio(){
    String output = portfolio.outputPortfolio();
    
    String directory = System.getProperty("user.home");
    String fileName = "portfolio.txt";
    String absolutePath = directory + File.separator + fileName;

    // write the content in file 
    try{
      PrintWriter writer = new PrintWriter(absolutePath, "UTF-8");
      writer.println(output);
      writer.close();
      return true;
    } 
    catch(IOException e) {
      return false;
    }
  }
  
  
} 