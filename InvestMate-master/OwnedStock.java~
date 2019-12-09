import java.util.*;
import java.text.*;


public class OwnedStock{
  public String name;
  public String ticker;
  public int shares;
  public Date purchased;
  
  public OwnedStock(String name, String ticker, int shares, String purchased){
    Date date = OwnedStock.convertDate(purchased);
    this.name = name;
    this.ticker = ticker;
    this.shares = shares;
    this.purchased = date;
  }
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name;
  }
  
  public String getTicker(){
    return ticker;
  }
  
  public void setTicker(String ticker){
    this.ticker = ticker;
  }
  
  public int getShares(){
    return shares;
  }
  
  public void setShares(int shares){
    this.shares = shares;
  }
  
  public boolean removeShares(int sharesRemoved){
    if((this.shares - sharesRemoved) <= 0){
      return false;
    }
    else{
      this.shares -= sharesRemoved;
      return true;
    }

  }
  
  
  public Date getPurchased(){
    return purchased;
  }
  
  public void setPurchased(Date purchased){
    this.purchased = purchased;
  }
  
  
  public static Date convertDate(String date){
    SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
    try{
      return format.parse(date); 
    }
    catch(ParseException e){
      return null;
    }
  }
  
}