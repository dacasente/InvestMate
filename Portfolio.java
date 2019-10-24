import java.util.*;

public class Portfolio{
  private ArrayList<OwnedStock> portfolio;

  
  //This is the constructor method and will be used in onboard portfolio
  public Portfolio(String[] stockNames, String[] ticker, int[] stockAmounts, Date[] datePurchased){
    portfolio = new ArrayList<OwnedStock>();
    for(int i=0; i < stockNames.length; i++){
      OwnedStock temp = new OwnedStock(stockNames[i], ticker[i], stockAmounts[i], datePurchased[i]);
      portfolio.add(temp);
    }
  }
  
  //This is the constructor method used for importing a portfolio
  public Portfolio(ArrayList<OwnedStock> portfolio){
    for(int i=0; i< portfolio.size(); i++){
      this.portfolio.add(portfolio.get(i));
    }
  }
  
  public ArrayList<OwnedStock> getPortfolio(){
    return portfolio;
  }
  
  public OwnedStock getSpecificStock(String stockName){
    OwnedStock searched = null;
    for(int i=0; i< portfolio.size(); i++){
      if(stockName.equals(portfolio.get(i).getName()))
        searched = portfolio.get(i);
    }
    return searched;
  }
  
  public void buyStock(String name, String ticker, int amount, Date date){
    OwnedStock temp = new OwnedStock(name, ticker, amount, date);
    portfolio.add(temp);
    
  }
  
  public int sellStock(String name, int amount){
    if(this.getSpecificStock(name) != null){
      for(int i=0; i< portfolio.size(); i++){
        if(name.equals(portfolio.get(i).getName())){
          boolean keepStock = portfolio.get(i).removeShares(amount);
          if(keepStock)
            return amount;
          else{
            int amountSold = portfolio.get(i).getShares();
            portfolio.remove(i);
            return amountSold;
          }
        }
      }
    }
    else{
     return -1; 
    }
    return -1;
  }
}