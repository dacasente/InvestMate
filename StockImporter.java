
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
 
 public static float getCurrentPrice(String symbol){
  //Using a StringBuilder...
  StringBuilder urlBuilder = new StringBuilder();
  //We specify our url...
  urlBuilder.append("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=");
  //We define our stock that we'd like to recieve data for...
  urlBuilder.append(symbol);
  urlBuilder.append("&apikey=7X34UXTUDREKB4IK&datatype=csv");

  try {
   //We try to connect to our url...
   URL url = new URL(urlBuilder.toString());
   URLConnection urlConn = url.openConnection();
   //and instantiate an inputstream to read from the URL...
   InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
   BufferedReader buff = new BufferedReader(inStream);
   buff.readLine();
   String line = buff.readLine();
   while (line != null){
    String [] data = line.split(",");
    return (Float.parseFloat(data[4]));
   }
  }

  catch (MalformedURLException mu){
   System.out.println(mu.getMessage());
   return 0;
  }
  catch (IOException io){
   System.out.println(io.getMessage());
   return 0;
  }
  catch(ArrayIndexOutOfBoundsException ae){
   System.out.println("INVALID STOCK SYMBOL");
   return 0;
  }
  return (0);
 }
 
 public static String[] getStockInfo(String symbol){ 
  // This method can take in any keywords for a stock...(name, symbol, etc) and will return the array of all information
  // about that stock With the format (Symbol, Name, Type, Location, Market Open, Market Close, Time Zone, Currency, Match to keyword)
   
  //Using a StringBuilder...
  StringBuilder urlBuilder = new StringBuilder();
  //We specify our url...
  urlBuilder.append("https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=");
  //We define our stock that we'd like to recieve data for...
  urlBuilder.append(symbol);
  urlBuilder.append("&apikey=7X34UXTUDREKB4IK&datatype=csv");

  try {
   //We try to connect to our url...
   URL url = new URL(urlBuilder.toString());
   URLConnection urlConn = url.openConnection();
   //and instantiate an inputstream to read from the URL...
   InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
   BufferedReader buff = new BufferedReader(inStream);
   buff.readLine();
   String line = buff.readLine();
   if (line!=null){
   String [] data = line.split(",");
   return data;
   }
   else{
     return null;
   }
  }

  catch (MalformedURLException mu){ 
   System.out.println(mu.getMessage());
   return null;
  }
  catch (IOException io){
   System.out.println(io.getMessage());
   return null;
  }
  catch(ArrayIndexOutOfBoundsException ae){
   System.out.println("INVALID STOCK SYMBOL");
   return (null);
  }
 }
 
  public static ArrayList<String> getStockList(String symbol){
  // This method takes in a keyword and returns the list of names for the top stocks that match that keyword
  // MSFT returns a list of microsoft stocks for example.
  
  //Using a StringBuilder...
  StringBuilder urlBuilder = new StringBuilder();
  //We specify our url...
  urlBuilder.append("https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=");
  //We define our stock that we'd like to recieve data for...
  urlBuilder.append(symbol);
  urlBuilder.append("&apikey=7X34UXTUDREKB4IK&datatype=csv");
  
  ArrayList<String> output = new ArrayList<String>();
  try {
   //We try to connect to our url...
   URL url = new URL(urlBuilder.toString());
   URLConnection urlConn = url.openConnection();
   //and instantiate an inputstream to read from the URL...
   InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
   BufferedReader buff = new BufferedReader(inStream);
   buff.readLine();
   String line = buff.readLine();
   while (line != null){
     String[] data = line.split(",");
     output.add(data[1]);
     line = buff.readLine();
   }
  }
  catch (MalformedURLException mu){ 
   System.out.println(mu.getMessage());
   return null;
  }
  catch (IOException io){
   System.out.println(io.getMessage());
   return null;
  }
  catch(ArrayIndexOutOfBoundsException ae){
   System.out.println("INVALID STOCK SYMBOL");
   return (null);
  }
  return output;
 }
 
 

 public static String getStockSymbol(String keyword){ //Returns the symbol of the stock most closely matching the keyword (can be symbol or name)
   String[] output = getStockInfo(keyword);
   if (output!=null){
     return getStockInfo(keyword)[0];
   }else{
     return null;
   } 
 }

 public static String getStockName(String keyword){ //Returns the name of the stock most closely matching the keyword
   String[] output = getStockInfo(keyword);
   if (output!=null){
     return getStockInfo(keyword)[1];
   }else{
     return null;
   } 
 }
 
 public static String getStockType(String keyword){ //Returns the type of the stock most closely matching the keyword (can be symbol or name)
   String[] output = getStockInfo(keyword);
   if (output!=null){
     return getStockInfo(keyword)[2];
   }else{
     return null;
   } 
 }
 
 public static String getStockLocale(String keyword){ //Returns the location of the stock most closely matching the keyword (can be symbol or name)
   String[] output = getStockInfo(keyword);
   if (output!=null){
     return getStockInfo(keyword)[3];
   }else{
     return null;
   } 
 }
 
 public static String getStockCurrency(String keyword){ //Returns the currency ues at the location of the stock most closely matching the keyword (can be symbol or name)
   String[] output = getStockInfo(keyword);
   if (output!=null){
     return getStockInfo(keyword)[7];
   }else{
     return null;
   } 
 }
 
 
}
