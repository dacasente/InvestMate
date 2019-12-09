
/**
 * 
 * @author davidcasente
 *This class creates a stock that is to inputed into a user's portfolio and 
 *keeps track of all the relevent stock informaiton related to a user
 */
public class OwnedStock {
	private String name;
	private String ticker;
	private int shares;
	private String day;
	private String month;
	private String year;

	/**
	 * initializes the stock for a user
	 * @param name
	 * @param ticker
	 * @param shares
	 * @param month
	 * @param day
	 * @param year
	 */
	public OwnedStock(String name, String ticker, int shares, String month, String day, String year) {
		this.name = name;
		this.ticker = ticker;
		this.shares = shares;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * 
	 * @return the name of the stock
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * sets the name of the stock
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the ticker of the stock
	 */
	public String getTicker() {
		return ticker;
	}

	/**
	 * 
	 * @param ticker
	 * sets the ticker
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public boolean removeShares(int sharesRemoved) {
		if ((this.shares - sharesRemoved) <= 0) {
			return false;
		} else {
			this.shares -= sharesRemoved;
			return true;
		}

	}

	public void setPurchased(String day, String month, String year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;

	}

	public static String convertToDay(String date) {
		String[] dmy = date.split("\\/");
		return dmy[1];
	}

	public static String convertToMonth(String date) {
		String[] dmy = date.split("\\/");
		return dmy[0];
	}

	public static String convertToYear(String date) {
		String[] dmy = date.split("\\/");
		return dmy[2];
	}

}