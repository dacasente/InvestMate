import java.util.*;

public class Portfolio {
	private ArrayList<OwnedStock> portfolio;

	// This is the constructor method and will be used in onboard portfolio
	public Portfolio(String[] stockNames, String[] ticker, int[] stockAmounts, String[] datePurchased){
    portfolio = new ArrayList<OwnedStock>();
    for(int i=0; i < stockNames.length; i++){
    	String day = OwnedStock.convertToDay(datePurchased[i]);
    	String month = OwnedStock.convertToMonth(datePurchased[i]);
    	String year = OwnedStock.convertToYear(datePurchased[i]);
    	OwnedStock temp = new OwnedStock(stockNames[i], ticker[i], stockAmounts[i], month, day , year);
    	portfolio.add(temp);
    }
  }

	// This is the constructor method used for importing a portfolio
	public Portfolio(ArrayList<OwnedStock> port) {
		portfolio = port;
	}

	public ArrayList<OwnedStock> getPortfolio() {
		return portfolio;
	}

	public OwnedStock getSpecificStock(String ticker) {
		OwnedStock searched = null;
		for (int i = 0; i < portfolio.size(); i++) {
			if (ticker.equals(portfolio.get(i).getTicker()))
				searched = portfolio.get(i);
		}
		return searched;
	}

	

	public String outputPortfolio() {
		String output = "";
		for (int i = 0; i < portfolio.size(); i++) {
			output += "" + portfolio.get(i).getName() + "_" + portfolio.get(i).getTicker() + "_"
					+ portfolio.get(i).getShares() + "_" + portfolio.get(i).getMonth() 
					+ "/" + portfolio.get(i).getDay() + "/" + portfolio.get(i).getYear();
			if (i < (portfolio.size() - 1)) {
				output += "~";
			}
		}
		return output;
	}

}