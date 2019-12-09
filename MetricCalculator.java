import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.lang.Math;

/**
 * 
 * @author davidcasente
 * This class calculates all metrics necessary for the application.
 *  It is utilized on the main page and stock search to calculate the price changes, and
 *  the stock analysis to compare values that helps create analysis.
 *  
 */
public class MetricCalculator {
	private String name;
	private int outlook;
	private Double[] prices;
	private Double eps;

	/**
	 * creates the metric calculator. Grabs the relevant stock info from the stock database.
	 * @param name
	 * @param outlook
	 */
	public MetricCalculator(String name, String outlook) {
		if (outlook.equals("3 Days")) {
			this.outlook = 3;
		} else if (outlook.equals("1 Week")) {
			this.outlook = 7;
		} else if (outlook.equals("1 Month")) {
			this.outlook = 21;
		} else {
			this.outlook = 63;
		}

		this.name = name;
		StockDatabase stockdb = new StockDatabase();
		prices = stockdb.getStockPrices(name);
		eps = stockdb.getStockEps(name);
	}

	
	/**
	 * 
	 * @return outlook
	 */
	public String getOutlook() {
		if (outlook == 3) {
			return "3 Days";
		} else if (outlook == 7) {
			return "1 Week";
		} else if (outlook == 21) {
			return "1 Month";
		} else {
			return "3 Months";
		}
	}

	/**
	 * 
	 * @param outlook
	 * @return the outlook in format of number of days
	 */
	public int numOutlook(String outlook) {
		int output = 0;
		if (outlook.equals("3 Days")) {
			output = 3;
		} else if (outlook.equals("1 Week")) {
			output = 7;
		} else if (outlook.equals("1 Month")) {
			output = 21;
		} else {
			output = 63;
		}
		return output;

	}

	/**
	 * sets the outlook of the calculator
	 * @param outlook
	 */
	public void setOutlook(String outlook) {
		if (outlook.equals("3 Days")) {
			this.outlook = 3;
		} else if (outlook.equals("1 Week")) {
			this.outlook = 7;
		} else if (outlook.equals("1 Month")) {
			this.outlook = 21;
		} else {
			this.outlook = 63;
		}

	}

	/**
	 * 
	 * @return eps variable
	 */
	public Double getEps() {
		return eps;
	}

	/**
	 * 
	 * @return the stock price of the last close
	 */
	public Double getPrevClose() {
		return prices[0];
	}
	
	

	/**
	 * 
	 * @param quantity
	 * @return the price difference between the last two days
	 */
	public Double getTodayChange(int quantity) {
		Double change = prices[0] - prices[1];
		return (Double) change * quantity;
	}

	/**
	 * 
	 * @param purchased
	 * @param quantity
	 * @return the price difference between today and when the stock was purchased
	 */
	public Double getNetChange(String purchased, int quantity) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {
			Date dateNow = Calendar.getInstance().getTime();
			Date datePurchased = formatter.parse(purchased);

			long diff = dateNow.getTime() - datePurchased.getTime();
			int days = Math.round(diff / (1000 * 60 * 60 * 24));

			Double change = prices[0] - prices[days];
			return (Double) change * quantity;
		} catch (Exception e) {
			return -0.00001;
		}

	}

	/**
	 * 
	 * @return gets the lowest stock price in three months
	 */
	public Double getThreeMonthLow() {
		Double min = 100000000.0;
		for (int i = 0; i < outlook; i++) {
			if (min > prices[i]) {
				min = prices[i];
			}
		}
		return min;
	}

	/**
	 * 
	 * @return gets the highest the stock price has been in the last three months
	 */
	public Double getThreeMonthHigh() {
		Double max = 0.0;
		for (int i = 0; i < outlook; i++) {
			if (max < prices[i]) {
				max = prices[i];
			}
		}
		return max;
	}

	/**
	 * 
	 * @return the pe ratio of the stock
	 */
	public Double getPERatio() {
		return prices[0] / eps;

	}

	/**
	 * 
	 * @return the definition of pe ratio
	 */
	public static String getPERatioDefinition() {
		String output = "The P/E Ratio equates the current stock price of a "
				+ "company to its earnings per share. Also known as an earnings multiple,"
				+ " the P/E Ratio tells us the ratio of how many dollars an investor spends "
				+ "on a stock to how many dollars that company earns. The purpose of\n this metrics "
				+ "is too see if investors are overpaying or underpaying for a stock.";
		return output;

	}

	/**
	 * 
	 * @return return the  pe ratio based on the entire outlook
	 */
	public Double getHistPERatio() {
		Double sumPrices = 0.0;
		for (int i = 0; i < outlook; i++) {
			sumPrices += prices[i];
		}

		Double avePrice = sumPrices / outlook;
		return avePrice / eps;
	}

	/**
	 * 
	 * @return the average price over the outlook
	 */
	public Double getHistPrice() {
		Double sumPrices = 0.0;
		for (int i = 0; i < outlook; i++) {
			sumPrices += prices[i];
		}

		return sumPrices / outlook;
	}

	
	/**
	 * 
	 * @return the definition of the stock price
	 */
	public static String getPriceDefinition() {
		String output = "The price of a company's stock is equivalent to the market capitalization of a"
				+ " company divided by the number of outstanding\n shares. For example if a company has a "
				+ "market capitalization of 400 million and has 50 million outstanding shares. The purpose of this"
				+ " metric is obviously to determine how much a stock costs, but also to notice trends in this context.";
		return output;
	}

	/**
	 * 
	 * @param dur
	 * @return the momentum of the stock given the duration
	 */
	public Double getMomentum(String dur) {
		int duration = numOutlook(dur);
		Double lastPrice = prices[duration - 1];

		return prices[0] - lastPrice;
	}
	
	/**
	 * 
	 * @param dur
	 * @return the historical momentum given the duration
	 */
	
	public Double getHistMomentum(String dur) {
		
		int start = numOutlook(dur);
		int end = start * 2;
		Double lastPrice = prices[end - 1];

		return prices[start] - lastPrice;
	}

	/**
	 * 
	 * @return the definition of market momentum
	 */
	public static String getMomentumDefinition() {
		String output = "The market momentum of a stock is the net gain or loss of the stock price over a duration"
				+ " can be calcualted as the stock\n price on the last day subtracted by the stock price on the first "
				+ "day. The purpose of this metric is to define the trend of the stock during a duration";
		return output;
	}

	/**
	 * 
	 * @return the relative strength index of the stock
	 */
	public Double getRSI() {
		Double sumPosDays = 0.0;
		Double sumNegDays = 0.0;
		int numPos = 0;
		for (int i = 0; i < outlook; i++) {
			if (prices[i] >= prices[i + 1]) {
				sumPosDays += prices[i];
				numPos++;
			} else {
				sumNegDays += prices[i];
			}
		}
		Double avePosDays = sumPosDays / numPos;
		Double aveNegDays = sumNegDays / (outlook - numPos);
		Double relativeStrength = avePosDays / aveNegDays;
		return (double) 100 - (100 / (1 + (relativeStrength)));
	}

	/**
	 * 
	 * @return the definition of relative strength index
	 */
	public static String getRSIDefinition() {
		String output = "The relative strength index is a measure of whether over purchasing or underpurchasing are "
				+ "driving the stock price up or driving the stock price down respectively. This metric can be caluclated as "
				+ "100 - (100 / (average stock price on a gaining day) / (average stock price on a losing day)). The purpose "
				+ "of this metric is to determine if overselling or overbuying is present, which will help determine the future "
				+ "trend of the price.";
		return output;
	}

	/**
	 * 
	 * @param dur
	 * @return the exponential moving average for the stock
	 */
	public Double getEMA(String dur) {
		int duration = numOutlook(dur);
		Double weight = (double) 2 / (duration + 1);
		Double ema = prices[duration];
		for (int i = duration - 1; i >= 0; i--) {
			ema = (prices[i] * weight) + (ema * (1 - weight));
		}
		return ema;
	}

	/**
	 * 
	 * @return the definition of exponential moving average
	 */
	public static String getEMADefinition() {
		String output = "The exponential moving average is essentially a more sophisticated version of the average stock price "
				+ "over a duration. Instead of taking the simple average, the exponential moving average weights more recent prices"
				+ " in a duration exponentially more than the previous price. THe purpose of this metric is too smooth out the "
				+ "potential noise of the daily price changes and to have the most recent prices more pronounced as they are more "
				+ "likely to contribute to future short term trends.";
		return output;
	}
	
	/**
	 * 
	 * @return the stock price values for the graph
	 */
	public Double[] getPriceGraphY() {
		Double[] yPrices = new Double[outlook];
		
		for(int i = 0; i < yPrices.length; i++) {
			yPrices[i] = prices[i];
			
		}
		
		return yPrices;
		
	}
	
	/**
	 * 
	 * @return the date values for the graph
	 */
	public String[] getPriceGraphX() {
		Date today = Calendar.getInstance().getTime();
		LocalDate day = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		String[] dates = new String[outlook];
		
		for(int i=0; i < dates.length; i++) {
			String strDay = "" + day.getMonthValue() + "/" 
							   + day.getDayOfMonth() + "/"
							   + day.getYear();
			
			dates[i] = strDay;
			day = day.minusDays(1);
			
		}
		
		return dates;
		
	}

}