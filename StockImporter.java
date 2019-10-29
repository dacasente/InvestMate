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


}
