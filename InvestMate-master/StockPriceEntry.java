/**
 * Auto Generated Java Class.
 */

import java.util.Date;

public class StockPriceEntry {
  
  String type;
  Date date;
  String simpleDate;
  float open;
  float high;
  float low;
  float close;
  float volume;
  
  
  StockPriceEntry(String type, Date date, String simpleDate, float open, float high, float low, float close, float volume){
    this.type = type;
    this.date = date;
    this.open = open;
    this.high = high;
    this.low = low;
    this.close = close;
    this.volume = volume;
    this.simpleDate = simpleDate;
  }
  
  public String getType(){
    return this.type;
  }
  public Date getDate(){
    return this.date;
  }
  public float getOpen(){
    return this.open;
  }
  public float getHigh(){
    return this.high;
  }
  public float getLow(){
    return this.low;
  }
  public float getClose(){
    return this.close;
  }
  public float getVolume(){
    return this.volume;
  }
  public String getSimpleDate(){
    return this.simpleDate;
  }
  
}
