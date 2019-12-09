public class StockAnalysis{
	private String name;
	private int outlook;
  private int peComp = 0;
  private int priceComp = 0;
  private int mmComp = 0;
  private int rsiComp = 0;
  private int emaComp = 0;
  private MetricCalculator company; 
  
  public StockAnalysis(String name, String outlook){
	  if(outlook.equals( "3 Days")){
	      this.outlook = 3;
	    }
	    else if(outlook.equals("1 Week")){
	      this.outlook = 7;
	    }
	    else if(outlook.equals("1 Month")){
	      this.outlook = 21;
	    }
	    else{
	      this.outlook = 63;
	    }

	    this.name = name;
	    
	    company = new MetricCalculator(name, outlook);
  }
  
  public String getOutlook(){
    if(outlook == 3){
      return "3 Days";
    }
    else if(outlook == 7){
      return "1 Week";
    }
    else if(outlook == 21){
      return "1 Month";
    }
    else{
      return "3 Months";
    }
  }
  
  public void setOutlook(String outlook) {
	  if(outlook.equals( "3 Days")){
	      this.outlook = 3;
	    }
	    else if(outlook.equals("1 Week")){
	      this.outlook = 7;
	    }
	    else if(outlook.equals("1 Month")){
	      this.outlook = 21;
	    }
	    else{
	      this.outlook = 63;
	    }
	  
  }
  
  
  
  
  public String getIntroduction(){
    String temp = "Welcome to the simple stock assessment tool. This tool will guide you through how to calculate fundamtental metrics in order\n to evaluate a stock. In addition, we will explain our evaluation of each metric and come to a conclusion as to whether we reccommend the\n stock being assessed.";
    return temp;
  }
  
  
  
  
  public String getPERatio(){
    String output = "The P/E Ratio equates the current stock price of a company to its earnings per share. Also known as an earnings multiple,\n the P/E Ratio tells us the ratio of how many dollars an investor spends on a stock to how many dollars that company earns. The purpose of\n this metrics is too see if investors are overpaying or underpaying for a stock.";
    double currentPE = company.getPERatio();
    double histPE = company.getHistPERatio();
    double dif = difference(histPE, currentPE);
    
    if(dif < -20){
      output = output + " Based on the large negative difference between the current P/E Ratio and the historical P/E Ratio, we have determined\n that currently investors are underpaying for the stock relative to history. This is a positive sign in purchasing a stock.";
      peComp = 1;
    }
    else if(dif >= -20 && dif <= 20){
      output = output + " Based on the small relative difference between the current P/E Ratio and the historical P/E Ratio, we have determined\n that currently investors are neither overpaying nor underpaying for the stock relative to history. This is a neutral sign in purchasing\n a stock.";
      peComp = 0;
    }
    else{
      output = output + " Based on the large positive difference between the current P/E Ratio and the historical P/E Ratio, we have determined\n that currently investors are overpaying for the stock relative to history. This is a negative sign in purchasing a stock.";
      peComp = -1;
    }
    return output;
  }
  
  
  
  public String getPrice(){
    String output = "The price of a company's stock is equivalent to the market capitalization of a company divided by the number of outstanding\n shares. For example if a company has a market capitalization of 400 million and has 50 million outstanding shares. The purpose of this\n metric is obviously to determine how much a stock costs, but also to notice trends in this context.";
    double currentPrice = company.getPrevClose();
    double histPrice = company.getHistPrice();
    double dif = difference(histPrice, currentPrice);
    
    if(dif < -15){
      output = output + " Based on the large negative difference between the current price and the historical price, we have determined that the\n stock has significantly devaluated over this time period. This is a negative sign in purchasing a stock.";
      priceComp = -1;
    }
    else if(dif >= -15 && dif <= 15){
      output = output + " Based on the small positive or negative difference between the current price and the historical price, we have\n determined that currently the stock has neither devaluated nor inflated over this time period. This is a positive sign in purchasing a stock.";
      priceComp = 1;
    }
    else{
      output = output + " Based on the large positive increase between the current price and the historical price, we have determined that\n currently the stock price has significantly inflated over this time period and the price trend is unpredictable. This is a neutral sign in\n purchasing a stock.";
      priceComp = -1;
    }
    return output;
  }
    
    
  
  
  public String getMomentum(){
    String output = "The market momentum of a stock is the net gain or loss of the stock price over a duration can be calcualted as the stock\n price on the last day subtracted by the stock price on the first day. The purpose of this metric is to define the trend of the stock\n during a duration";
    double currentMom = company.getMomentum(outlook);
    double histMom = company.getMomentum(outlook *2);
    double dif = difference(currentMom, histMom);
    
    if(dif <= 0){
      output = output + " Based on the negative difference between the current market momentum and the historical market momentum, we have\n determined that the stock price is trending downward and is unlikely to appreciate in the near future. This is a negative sign in\n purchasing a stock.";
      mmComp = -1;
    }
    else if(dif > 0 && dif <= 30){
      output = output + " Based on the small positive difference between the current market momentum and the historical momentum, we have determined\n that it is likely that the positive trend will continue into the near future. This is a positive sign in purchasing a stock.";
      mmComp = 1;
    }
    else{
      output = output + " Based on the large positive increase between the current market momentum and the historical market momentum, we have\n determined that currently the stock price has significantly inflated over this recent time period, so it is unknown whether the\n stock will continue this trend or begin to dip due to over inflation. This is a neutral sign in purchasing a stock.";
      mmComp = 0;
    }
    return output;
  }
  
  
  
  public String getRSI(){
    String output = "The relative strength index is a measure of whether over purchasing or underpurchasing are driving the stock price up or\n driving the stock price down respectively. This metric can be caluclated as 100 - (100 / (average stock price on a gaining day) /\n (average stock price on a losing day)). The purpose of this metric is to determine if overselling or overbuying is present, which will help determine the future trend of the price.";
    double rsi = company.getRSI();
    
    
    if(rsi < 35){
      output = output + "The small relative strength index indicates that investors are overselling the stock, meaning the stock price is lower than\n it should be. From this we can infer a short term positive trend. This is a positive sign in purchasing a stock.";
      rsiComp = 1;
    }
    else if(rsi >= 35 && rsi <= 65){
      output = output + "The average relative strength index indicates that investors are neither overselling nor overbuying the stock, meaning the\n stock price is close to where it should be. From this we cannot infer any short term trend. This is a neutral sign in\n purchasing a stock.";
      peComp = 0;
    }
    else{
      output = output + "The large relative strength index indicates that investors are overbuying the stock, meaning the stock price is higher than\n it should be. From this we can infer a short term negative trend. This is a negative sign in purchasing a stock.";
      peComp = -1;
    }
    return output;
  }
  
  
  public String getEMA(){
    String output = "The exponential moving average is essentially a more sophisticated version of the average stock price over a duration. Instead of\n taking the simple average, the exponential moving average weights more recent prices in a duration exponentially more\n than the previous price. THe purpose of this metric is too smooth out the potential noise of the daily price changes and to have the most recent prices more pronounced as they are more likely to contribute to future short term trends.";
    double currentEMA = company.getEMA(outlook);
    double histEMA = company.getEMA(outlook);
    double dif = difference(histEMA, currentEMA);
    
    if(dif <= 0){
      output = output + " Based on the negative difference between the current EMA and the historical EMA, we have determined that the stock in moving\n downward more over this time period in comparison to the previous one and is unlikely to have a short term positive\n trend. This is a negative sign in purchasing a stock.";
      emaComp = -1;
    }
    else if(dif > 0 && dif <= 20){
      output = output + " Based on the small positive difference between the current EMA and the historical EMA, we have determined that currently the\n stock trending more positively over this time period than in the previous one and is likely to continue this short term\n positive trend. This is a positive sign in purchasing a stock.";
      emaComp = 1;
    }
    else{
      output = output + " Based on the large positive increase between the current EMA and the historical EMA, we have determined that currently the stock\n price has significantly inflated over this time period in comparison to the last one. We are uncertain whether the\n positive trend will continue or if a short term negative trend will occur. This is a neutral sign in purchasing a stock.";
      emaComp = 0;
    }
    return output;
  }
  
  public double difference(double previous, double current){
    double dif = ((current - previous) * 100) / previous;
    return dif;
  }
  
  public int stockScore() {
	  int numPos = 0;
	  int numNeg = 0;
	    int numNeutral = 0;
	  if(peComp == 1){
	      numPos ++;
	    }
	    else if(peComp == 0){
	      numNeutral++;
	    }
	    else{
	      numNeg++;
	    }
	    
	    if(priceComp == 1){
	      numPos ++;
	    }
	    else if(priceComp == 0){
	      numNeutral++;
	    }
	    else{
	      numNeg++;
	    }
	    
	    if(mmComp == 1){
	      numPos ++;
	    }
	    else if(mmComp == 0){
	      numNeutral++;
	    }
	    else{
	      numNeg++;
	    }
	    
	    if(rsiComp == 1){
	      numPos ++;
	    }
	    else if(rsiComp == 0){
	      numNeutral++;
	    }
	    else{
	      numNeg++;
	    }
	    
	    if(emaComp == 1){
	      numPos ++;
	    }
	    else if(emaComp == 0){
	      numNeutral++;
	    }
	    else{
	      numNeg++;
	    }
	    return (numPos * 3) + (numNeutral * 1) + (numNeg * -3);
  }
  
  public String conclusion(){
    int numPos = 0;
    int numNeg = 0;
    int numNeutral = 0;
    String output = "Putting together our analysis for each metric will determine if we overall believe the stock is likely to have a short term increase,\n is likely to have a short term decrease, or if we cannot determine the short term trend.";
    if(peComp == 1){
      numPos ++;
    }
    else if(peComp == 0){
      numNeutral++;
    }
    else{
      numNeg++;
    }
    
    if(priceComp == 1){
      numPos ++;
    }
    else if(priceComp == 0){
      numNeutral++;
    }
    else{
      numNeg++;
    }
    
    if(mmComp == 1){
      numPos ++;
    }
    else if(mmComp == 0){
      numNeutral++;
    }
    else{
      numNeg++;
    }
    
    if(rsiComp == 1){
      numPos ++;
    }
    else if(rsiComp == 0){
      numNeutral++;
    }
    else{
      numNeg++;
    }
    
    if(emaComp == 1){
      numPos ++;
    }
    else if(emaComp == 0){
      numNeutral++;
    }
    else{
      numNeg++;
    }
    
    if(numPos >= 3){
      output = output + "Based on the insight we gained from the five metrics, we believe that a short term positive increase is likely to occur and\n therefore the stock should be purchased at this time.";
    }
    else if(numNeg >= 3){
      output = output + "Based on the insight we gained from the five metrics, we believe that a short term negative increase is likely to occur and\n therefore the stock should not be purchased at this time.";
    }
    else{
      output = output + "Based on the insight we gained from the five metrics, we are unable to determine whether a short term increase or decrease is\n likely to occur and therefore further research needs to be conducted.";
    }
    
    return output;
  }
  
  
}