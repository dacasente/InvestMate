/**
 * Auto Generated Java Class.
 */
import java.util.Date;
import java.util.ArrayList;

public class Stock {
  
  String symbol;
  ArrayList<StockPriceEntry> dates = new ArrayList<StockPriceEntry>();
  
  Stock(String symbol){
    this.symbol = symbol;
  }
  
  public String getSymbol(){
    return this.symbol;
  }
  
  public void populateDate(String type, Date date, String simpleDate, float open, float high, float low, float close, float volume){
    dates.add(new StockPriceEntry(type,date, simpleDate,open,high,low,close,volume));
  }
  
  public StockPriceEntry getDataAt(int i){
    return dates.get(i);
  }
  
  public StockPriceEntry getDataAtDate(String y, String m, String d){
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < dates.size(); i++){
      if (dates.get(i).getSimpleDate().compareTo(y+m+d) == 0){
        return dates.get(i);
      }
    }
    return null;
  }
}
