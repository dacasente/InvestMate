/**
 * Auto Generated Java Class.
 */
import java.io.*; 
import java.util.ArrayList; 
import java.io.BufferedReader;
import java.lang.StringBuilder;
public class DatabasePopulator {
  static String[] symbols = {"ACB","F","GE","FIT","GPRO","MSFT","AAPL","DIS","CRON","CGC","AMD","SNAP","PLUG","FB","TSLA","ZNGA","TWTR","AMZN","BABA","UBER","CHK","BAC","NIO","NFLX","T","SBUX","NVDA","APHA","GRPN","SQ","S","SIRI","KO","VOO","BYND","CRBP","WORK","ATVI","NKE","LYFT","MU","V","VSLR","INTC","NOK","PCG","CSCO","JCP","SPY","TLRY","PYPL","TCHEY","MJ","BRK.B","GLUU","NRZ","AUY","IQ","ROKU","CRM","WMT","BA","DNR","VKTX","VTI","PFE","ENPH","GOOGL","GM","TWLO","SHOP","JD","VZ","DBX","CPRX","LK","COST","PINS","BILI","SNE","CARA","AKS","ABBV","CRSP","CVS","SPWR","YETI","TGT","LLNW","TEVA","UGAZ","MCD","BOTZ","UAA","SFIX","ZM","JNJ","KHC","GOOG","WM"};
  
  public static String[] getNames(){
    String[] names = new String[200];
    int i = 0;
    for (String sym : symbols){
      names[i] = StockImporter.getStockInfo(sym)[1];
      i++;
    }
    return names;
  }
  
  
  //Important note to watch for here, this method only works if
  //the csv files are in the same folder as this class is
  //and returns all of the info from most recent to oldest,
  //front to back and the order of the stock info is the same 
  //as the order used in String[] symbols above.
  
  public static String[] parseCSVs() throws Exception{
    String currentDir = System.getProperty("user.dir");
    String[] results = new String[100];
    int i = 0;
    for (String name : symbols){
      File file  = new File(name + ".csv");
      System.out.println(file.getName());
      if (file.exists()){
        StringBuilder formatted = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null){
          formatted.append(line);
          formatted.append(",");
        }
        results[i] = formatted.toString();
        i++;
      }
    }
    System.out.println(results);
    return results;
  }

      
  public static String[] getSymbols(){
    return symbols;
  }
  
  public static Float[] getCurrentPrice(){
    Float[] prices = new Float[200];
    int i = 0;
    for (String sym : symbols){
      prices[i] = StockImporter.getCurrentPrice(sym);
      i++;
    }
    return prices;
  }
  
  public static Float[][] getHistoricalPrices(){
    Float[][] stockPrices = new Float[2][365];
    int i = 0;
    int j = 0;
    int k = 0;
    /*try{*/
      while (k < symbols.length){
        ArrayList<Float> temp = StockImporter.timeSeriesDaily(symbols[k]);
        while (j < 365){
          stockPrices[i][j] = temp.get(j);
          j++;
        }
        k++;
        i++;
      }
      return stockPrices;
    }
    /*catch(InterruptedException ie){
      System.out.println("Interrupted");
      return null;
    }*/
  
}