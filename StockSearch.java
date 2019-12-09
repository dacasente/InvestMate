import java.text.DecimalFormat;

public class StockSearch {
	private String sector;
	private String outlook;
	private Double priceMin;
	private Double priceMax;

	public StockSearch(String sector, String outlook, int priceMin, int priceMax) {
		this.sector = sector;
		this.outlook = outlook;
		this.priceMin = priceMin + 0.0;
		this.priceMax = priceMax + 0.0;
	}
	
	
	public String[][] search(){
		StockDatabase stockdb = new StockDatabase();
		String[][] outputList = new String[3][3];
		String[] nameList = stockdb.getStockNames(sector, priceMin, priceMax);
		int[] scores = new int[nameList.length];
		
		
		
		for(int i = 0; i < nameList.length; i++) {
			scores[i] = getStockScore(nameList[i]);
			
			
			
		}
		
		int maxScore = -7;
		int maxIndex = -1;
		int secondScore = -7;
		int secondIndex = -1;
		int thirdScore = -7;
		int thirdIndex = -1;
		
		for(int i = 0; i < scores.length; i++) {
			if(maxScore < scores[i]) {
				
				thirdIndex = secondIndex;
				thirdScore = secondScore;
				secondIndex = maxIndex;
				secondScore = maxScore;
				maxIndex = i;
				maxScore = scores[i];
				
			}
			
			else if(secondScore < scores[i]) {
				thirdIndex = secondIndex;
				thirdScore = secondScore;
				secondIndex = i;
				secondScore = scores[i];
				
			}
			else if(thirdScore < scores[i]) {
				thirdIndex = i;
				thirdScore = scores[i];
			}
			
		}
		String[] output = new String[3];
		
		
		output[0] = nameList[maxIndex];
		output[1] = "" + getStockRec(nameList[maxIndex]);
		output[2] = "" + getTodayChange(nameList[maxIndex]);
		
		outputList[0] = output;
		
		String[] outputTwo = new String[3];
		
		outputTwo[0] = nameList[secondIndex];
		outputTwo[1] = "" + getStockRec(nameList[secondIndex]);
		outputTwo[2] = "" + getTodayChange(nameList[secondIndex]);
		
		outputList[1] = outputTwo;
		
		String[] outputThree = new String[3];
		
		outputThree[0] = nameList[thirdIndex];
		outputThree[1] = "" + getStockRec(nameList[thirdIndex]);
		
		outputThree[2] = "" + getTodayChange(nameList[thirdIndex]);
		
		outputList[2] = outputThree;
		
		return outputList;
		
		
		
		
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
		DecimalFormat df = new DecimalFormat("###.###");

		MetricCalculator company = new MetricCalculator(name, outlook);
		double change = company.getTodayChange(1);
		String output = "";
		if(change > 0) {
			output = output + "+" + df.format(change);
			
		}
		else {
			output = output + df.format(change);
			
		}
		return output;
		
	}
	
	
}
