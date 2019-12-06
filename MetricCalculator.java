import java.text.SimpleDateFormat;  
import java.util.Date;
import java.lang.Math;

public class MetricCalculator{
  private String name;
  private int outlook;
  private double[] prices = {266.18,266.37,261.78,262.01,263.19,266.29,267.1,265.76,262.64,264.47,261.96,262.2,260.14,259.43,257.24,257.13,257.5,255.82,248.76,243.26,243.29,249.05,246.58,243.58,243.18,239.96,240.51,236.41,235.28,234.37,235.32,235.87,236.21,230.09,227.03,224.4,227.06,227.01,220.82,218.96,224.59,223.97,218.82,219.89,221.03,217.68,218.72,217.73,220.96,222.77,220.7,219.9,218.75,223.09,223.59,216.7,214.17,213.26,213.28,209.19,205.7,208.74,209.01,205.53,204.16,206.49,202.64,212.46,212.64,210.36,210.35,206.5,201.74,202.75,208.97,200.48,200.99,203.43,199.04,197,193.34,204.02,208.43,213.04,208.78,209.68,207.74,207.02,208.67,208.84,207.22,202.59,205.66,203.35,204.5,205.21,203.3,201.75,203.23,201.24,200.02,204.23,204.41,202.73,201.55,197.92,199.74,199.8,195.57,198.58,198.78,199.46,197.87,198.45,193.89,192.74,194.15,194.19,194.81,192.58,190.15,185.22,182.54,179.64,173.3,175.07,178.3,177.38,178.23,178.97,179.66,182.78,186.6,183.09,189,190.08,190.92,188.66,185.72,197.18,200.72};
  private double eps = 11.89;
  
  public MetricCalculator(String name, String outlook){
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
  
  public double getEps(){
    return eps;
  }
  
  public double getPrevClose(){
    return prices[0];
  }
  
  public double getTodayChange(int quantity) {
	  double change = prices[0] - prices[1];
	  return (double) change * quantity;
  }
  
  public double getNetChange(String today, String purchased, int quantity) {
	  SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	  
	  try {
		  Date dateNow = formatter.parse(today);
		  Date datePurchased = formatter.parse(purchased);
		  
		  long diff = dateNow.getTime() - datePurchased.getTime();
		  int days = Math.round(diff / (1000 * 60 * 60 * 24));
		  
		  double change = prices[0] - prices[days];
		  return (double) change * quantity;
	  }
	  catch(Exception e){
		  return -0.00001;
	  }
	  
  }
  
  
  
  public double getThreeMonthLow(){
    double min = 100000000;
    for(int i= 0; i < outlook; i++){
      if(min > prices[i]){
        min = prices[i];
      }
    }
    return min;
  }
  
  public double getThreeMonthHigh(){
    double max = 0;
    for(int i = 0; i < outlook; i++){
      if(max < prices[i]){
        max = prices[i];
      }
    }
    return max;
  }
  
  
  
  public double getPERatio(){
    return prices[0] / eps;
    
  }
  
  public double getHistPERatio(){
    double sumPrices = 0;
    for(int i = 0; i < outlook; i++){
      sumPrices += prices[i];
    }
    
    double avePrice = sumPrices / outlook;
    return avePrice / eps;
  }
  
  
  
  public double getHistPrice(){
    double sumPrices = 0;
    for(int i = 0; i < outlook; i++){
      sumPrices += prices[i];
    }
    
    return sumPrices / outlook;
  }
  
  
    
    
  public double getMomentum(int duration){
    double lastPrice = prices[duration - 1];
    
    return prices[0] - lastPrice;
  }
  
  public double getRSI(){
    double sumPosDays = 0;
    double sumNegDays = 0;
    int numPos = 0;
    for(int i = 0; i < outlook; i++){
      if(prices[i] >= prices[i+1]){
        sumPosDays += prices[i];
        numPos++;
      }
      else{
        sumNegDays += prices[i];
      }
    }
    double avePosDays = sumPosDays / numPos;
    double aveNegDays = sumNegDays / (outlook - numPos);
    double relativeStrength = avePosDays / aveNegDays;
    return (double) 100 - (100 / (1+ (relativeStrength)));
  }
  
  public double getEMA(int duration){
    double weight = (double) 2 / (duration + 1);
    double ema = prices[duration];
    for(int i = duration - 1; i >= 0; i--){
      ema = (prices[i] * weight) + (ema * (1 - weight));
    }
    return ema;
  }
  
  
  
  
}