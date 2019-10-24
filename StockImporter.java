import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Date;

public class StockImporter {
  
  ArrayList<Stock> stocks = new ArrayList<Stock>();
  /* This is a insatnce of the method that doesn't require and additional information about
   * our output, and defaults to CSV
   */
  public void getInfo (String stockName, String interval) {
    
    //Using a StringBuilder...
    StringBuilder urlBuilder = new StringBuilder();
    //We specify our url...
    urlBuilder.append("https://www.alphavantage.co/query?function=");
    //We define which interval we'd like to recieve data for...
    urlBuilder.append(interval);
    urlBuilder.append("&symbol=");
    //We define our stock that we'd like to recieve data for...
    urlBuilder.append(stockName);
    //We provide an API key...
    urlBuilder.append("&apikey=7X34UXTUDREKB4IK");
    //And finally, we define that we'd like it in csv format.
    urlBuilder.append("&datatype=csv");
    
    try {
      //We try to connect to our url...
      URL url = new URL(urlBuilder.toString());
      URLConnection urlConn = url.openConnection();
      //and instantiate an inputstream to read from the URL...
      InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
      BufferedReader buff = new BufferedReader(inStream);
      Stock s = new Stock(stockName);
      this.apiProcessor(buff, s);
      
    }
    catch (MalformedURLException mu){
      System.out.println(mu.getMessage());
    }
    catch (IOException io){
      System.out.println(io.getMessage());
    }
  }
  
  public void getInfo (String stockName, String interval, String output) {
    
    StringBuilder urlBuilder = new StringBuilder();
    urlBuilder.append("https://www.alphavantage.co/query?function=");
    urlBuilder.append(interval);
    urlBuilder.append("&symbol=");
    urlBuilder.append(stockName);
    urlBuilder.append("&outputsize=");
    urlBuilder.append(output);
    urlBuilder.append("&apikey=7X34UXTUDREKB4IK");
    urlBuilder.append("&datatype=csv");
    
    try {
      URL url = new URL(urlBuilder.toString());
      URLConnection urlConn = url.openConnection();
      InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
      BufferedReader buff = new BufferedReader(inStream);
      String line = buff.readLine();
      
      while (line != null){
        System.out.println(line);
        line = buff.readLine();
      }
      
    }
    catch (MalformedURLException mu){
      System.out.println(mu.getMessage());
    }
    catch (IOException io){
      System.out.println(io.getMessage());
    }
  }
  
  public void getInfo (String stockName, String interval, String output, String datatype) {
    
    StringBuilder urlBuilder = new StringBuilder();
    urlBuilder.append("https://www.alphavantage.co/query?function=");
    urlBuilder.append(interval);
    urlBuilder.append("&symbol=");
    urlBuilder.append(stockName);
    urlBuilder.append("&outputsize=");
    urlBuilder.append(output);
    urlBuilder.append("&apikey=7X34UXTUDREKB4IK");
    urlBuilder.append("&datatype=");
    urlBuilder.append(datatype);
    
    try {
      
      
      URL url = new URL(urlBuilder.toString());
      URLConnection urlConn = url.openConnection();
      InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
      BufferedReader buff = new BufferedReader(inStream);
      String line = buff.readLine();
      
      while (line != null){
        System.out.println(line);
        line = buff.readLine();
      }
      
    }
    catch (MalformedURLException mu){
      System.out.println(mu.getMessage());
    }
    catch (IOException io){
      System.out.println(io.getMessage());
    }
  }
  
  public void apiProcessor(BufferedReader buff, Stock s){
    try{
      buff.readLine();
      String line = buff.readLine();
      while (line != null){
        /*System.out.println(Integer.valueOf(line.substring(2,4)));
         System.out.println(Integer.valueOf(line.substring(5,7)));
         System.out.println(Integer.valueOf(line.substring(8,10)));*/
        
        /* This creates a date object by traversing the data and finding the month, date, year
         * May require a rework for two reasons
         * - Date(int,int,int) is deprecated
         * - This may not accurately handle dates before 2000
         */
        Date date = new Date((Integer.valueOf(line.substring(2,4)) + 100),(Integer.valueOf(line.substring(5,7))-1),(Integer.valueOf(line.substring(8,10))));
        String simpleDate = (line.substring(0,4) + line.substring(5,7) + line.substring (8,10));
        /* This traverses the data input and finds commas in order to find information about the
         * positions of the high, low, open, close and volume.
         */
        int[] commas = new int[10];
        int commaPos = 0;
        for (int i = 0; i< line.length(); i++){
          if (line.charAt(i) == ','){
            commas[commaPos] = i;
            commaPos++;
          }
        }
        
        /* This uses the found commas in the code to determine the position 
         * the open,high,low,close and volume for each entry in the data.
         */
        float open = (Float.valueOf(line.substring((commas[0]+1), commas[1])));
        float high = (Float.valueOf(line.substring((commas[1]+1), commas[2])));
        float low = (Float.valueOf(line.substring((commas[2]+1), commas[3])));
        float close = (Float.valueOf(line.substring((commas[3]+1), commas[4])));
        float volume = (Float.valueOf(line.substring(commas[4]+1)));
        s.populateDate(s.getSymbol(), date, simpleDate, open, high, low, close, volume);
        stocks.add(s);
        
        line=buff.readLine();
      }
    }
    catch (IOException io){
      System.out.println(io.getMessage());
    }
  }
  
  public Stock getStockAt(int i){
    return stocks.get(i);
  }
  
  public Stock getStockNamed(String s){
    for (int i=0; i<stocks.size(); i++){
      if (stocks.get(i).getSymbol().compareTo(s)==0){
        return stocks.get(i);
      }
    }
    return null;
  }
  
  
}
