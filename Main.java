
import java.util.ArrayList;  
public class Main {
	public static void main(String[] args) throws Exception {
		
		GeneralDatabase.createNewDatabase("stocks.db");
	    StockDatabase.createNewTable();
	    
	    StockDatabase stocks = new StockDatabase();
	    
	    Double[] applePrices = {266.18,266.37,261.78,262.01,263.19,266.29,267.1,265.76,262.64};
	    Double[] microsoftPrices = {223.09,223.59,216.7,214.17,213.26,213.28,209.19,205.7,208.74,209.01};
	    Double[] teslaPrices = {331.93,336.34,333.04,354.83,352.22,359.52,349.99,352.17,349.35,346.11};	    
	    Double[] homeDepotPrices = {225.55,231.08,232.02,229.86,229.79,228.1,225.41,226.25,224.67,228.12,230.83,230.21,230.99,233.98,233.8,232.66,233.0,232.87,231.13,228.15,224.15,224.07,227.91,227.32,221.95,218.21,218.65,217.47,221.02,220.4,217.09,207.95,203.65,201.79,201.59,208.33,207.01,210.02,211.57,207.91,208.8,204.94,212.15,212.83,213.69,217.36,218.04,216.91,215.55,214.71,213.08,211.27,213.04,214.44,215.61,217.26,218.7,218.23,214.04,210.75,212.0,212.91,211.46,212.1,210.14,210.28,207.97,207.02,206.42,204.74,205.5,209.39,211.25,207.94,207.48,206.98,205.77,202.35,198.94,198.01,198.05};
	    Double[] disneyPrices = {138.02,137.5,136.19,135.79,138.83,139.55,138.84,137.89,136.31,137.26,137.84,136.55,134.49,134.61,131.67,136.08,135.76,135.13,135.29,135.2,133.41,132.85,137.01,135.75,138.52,137.89,134.86,141.87,138.3,141.71,141.85,143.01,144.93,146.39,144.65,143.21,141.29,141.26,140.84,139.85,141.63,142.57,144.3,145.06,144.88,143.56,143.54,141.61,141.02,142.45,142.98,142.53,141.65,139.64,139.3,140.4,139.94};
	    
	    /*
	    stocks.addStock("Apple", "AAPL", "Information Technology", applePrices , 266.18 ,11.89);
	    stocks.addStock("Microsoft", "MSFT", "Information Technology", microsoftPrices, 223.09, 6.78);
	    stocks.addStock("Tesla", "TSLA", "Information Technology", teslaPrices, 331.93, 0.78 );
	    stocks.addStock("Home Depot", "HD", "Information Technology", homeDepotPrices, 225.55,10.06);
	    stocks.addStock("Walt Disney", "DIS", "Information Technology", disneyPrices, 138.02,6.64);
	    stocks.addStock("company69", "AAPL", "Energy", applePrices , 266.18 ,11.89);
	    stocks.addStock("company4", "MSFT", "Energy", microsoftPrices, 223.09, 6.78);
	    stocks.addStock("companya", "TSLA", "Energy", teslaPrices, 331.93, 0.78 );
	    stocks.addStock("companyb", "HD", "Energy", homeDepotPrices, 225.55,10.06);
	    stocks.addStock("companyd", "DIS", "Energy", disneyPrices, 138.02,6.64);
	    */
	    
	    String pls = StockPopulation.getPrices("GOOG");
	    System.out.println(pls);
	    StockSearch cool = new StockSearch("Information Technology", "3 Days", 0, 400);
	    
	    String[][] bob = cool.search();
	    
	    for(int i = 0; i < bob.length; i++) {
	    	for(int j = 0; j < bob[i].length; j++) {
	    		System.out.print(bob[i][j] + ",");
	    	}
	    	System.out.println();
	    	
	    }
	    
	    System.out.println(bob[1][1]);

	    MetricCalculator la = new MetricCalculator("Apple", "1 Week");
	    
	    String[] datees = la.getPriceGraphX();
	    Double[] pricees = la.getPriceGraphY();
	    
	    for(int i = 0; i < datees.length; i++) {
	    	System.out.print("(" + datees[i] + "," + pricees[i] + ")" + ",");
	    }
	    System.out.println();
	    
	    System.out.println(la.getNetChange("12/07/2019", 2));
	    
	    String[] out = stocks.getAllStockNames();
	    System.out.println(out[0]);
	    System.out.println(out[1]);
	    
	    Double eps = stocks.getStockEps("Apple");
	    System.out.println(eps);
	    
	    stocks.updateStockPrice("Apple", 269.00);
	    
	    System.out.println(stocks.getPriceString("Apple"));
	    
	    Double[] prices = stocks.getStockPrices("Tesla");
	    
	    System.out.println(prices[0] + " " +  prices[1] + "" + prices[2]);
	    /*
	    Double eps = stocks.getStockEps("Apple");
	    System.out.println(eps);
	    
	    Double[] prices = stocks.getStockPrices("Tesla");
	    
	    System.out.println(prices[0] + " " +  prices[1] + "" + prices[2]);

	    /*
		double[] applePrices = {266.18,266.37,261.78,262.01,263.19,266.29,267.1,265.76,262.64,264.47,261.96,262.2,260.14,259.43,257.24,257.13,257.5,255.82,248.76,243.26,243.29,249.05,246.58,243.58,243.18,239.96,240.51,236.41,235.28,234.37,235.32,235.87,236.21,230.09,227.03,224.4,227.06,227.01,220.82,218.96,224.59,223.97,218.82,219.89,221.03,217.68,218.72,217.73,220.96,222.77,220.7,219.9,218.75,223.09,223.59,216.7,214.17,213.26,213.28,209.19,205.7,208.74,209.01,205.53,204.16,206.49,202.64,212.46,212.64,210.36,210.35,206.5,201.74,202.75,208.97,200.48,200.99,203.43,199.04,197,193.34,204.02,208.43,213.04,208.78,209.68,207.74,207.02,208.67,208.84,207.22,202.59,205.66,203.35,204.5,205.21,203.3,201.75,203.23,201.24,200.02,204.23,204.41,202.73,201.55,197.92,199.74,199.8,195.57,198.58,198.78,199.46,197.87,198.45,193.89,192.74,194.15,194.19,194.81,192.58,190.15,185.22,182.54,179.64,173.3,175.07,178.3,177.38,178.23,178.97,179.66,182.78,186.6,183.09,189,190.08,190.92,188.66,185.72,197.18,200.72};
	    double appleEps = 11.89;
	    String appleOutlook = "3 Months";
	    MetricCalculator cool = new MetricCalculator("Apple", appleOutlook);
	    double output = cool.getPERatio();
	    System.out.println(output);
	    double price = cool.getNetChange("01/05/19", "01/01/19", 5);
	    
	    System.out.println(price);
	    
	    */
	    
	    GeneralDatabase.createNewDatabase("users.db");
	    UserDatabase.createNewTable();
	    String[] names = {"Apple", "Tesla"};
	    String[] tickers = {"AAPL", "TSLA"};
	    int[] amounts = {4, 7};
	    String[] dates = {"02/05/2003", "08/13/2012"};
	    Portfolio port = new Portfolio(names, tickers, amounts, dates);
	    
	    String[] names2 = {"Apple", "Tesla"};
	    String[] tickers2 = {"AAPL", "TSLA"};
	    int[] amounts2 = {4, 7};
	    String[] dates2 = {"02/05/2003", "08/13/2012"};
	    Portfolio port2 = new Portfolio(names2, tickers2, amounts2, dates2);
	    
	    
	    UserManager.addUser("George", "123Password", 23 , port);
	    UserManager.addUser("Ben", "456Password", 26 , port2);

	    ArrayList<User> userList = UserManager.getUsers();
	    
	    //User userGot = userdb.getAUser("George");
	    
	    
	    UserManager.updateName("Ben", "David");
	    UserManager.updateAge("George", 44);
	    UserManager.updatePassword("George", "hello");
	    UserManager.updatePortfolio("George", port2);
	    //System.out.println(userGot.getAge());
	    //userGot.getPortfolio().getSpecificStock("AAPL").getShares();
	    
	    
	
	}
}
