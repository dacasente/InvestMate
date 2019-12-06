
public class StockSearch {
	private String sector;
	private String outlook;
	private int priceMin;
	private int priceMax;

	public StockSearch(String sector, String outlook, int priceMin, int priceMax) {
		this.sector = sector;
		this.outlook = outlook;
		this.priceMin = priceMin;
		this.priceMax = priceMax;
	}
	
	public String[][] search(){
		
		
	}
	
	public int getStockScore(String name) {
		StockAnalysis company = new StockAnalysis(name, outlook);
		return company.stockScore();
		
	}
	
	public String getStockRec(String name) {
		int score = getStockScore(name);
		
		if(score >= 9){
		    return "Strong Buy";
		}
		else if(score >= 3){
		    return "Buy";
		}
		    
		else{
			return "Don't Buy";
		}
	}
	
	public String getTodayChange(String name) {
		MetricCalculator company = new MetricCalculator(name, outlook);
		double change = company.getTodayChange(1);
		String output = "";
		if(change > 0) {
			output = output + "+" + change;
			
		}
		else {
			output = output + change;
			
		}
		return output;
		
	}
	
	
}
