import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class MyTests{
  
  
  @Test
  public void createAPortfolioAndAddToUser() {
    //setting
    String[] names = {"one", "two", "three"};
    String[] tick = {"o", "t", "th"};
    int[] amount = {5, 3, 6};
    String[] dates = {"03/04/11", "11/23/01", "05/06/07"};
    Portfolio port = new Portfolio(names, tick, amount, dates);
    User me = new User("Chad", 24);
    me.createPortfolio(port.getPortfolio());

    // assert statements
    String one = "one";
    assertEquals(one, me.getPortfolio().getSpecificStock("o").getName());
    assertEquals(port.getSpecificStock("t").getPurchased(), me.getPortfolio().getSpecificStock("t").getPurchased());
    assertEquals("Chad", me.getName());
    assertEquals(true, me.savePortfolio());
    
    me.getPortfolio().buyStock("four","f",7, "07/02/1998");
    
    assertEquals(7, me.getPortfolio().getSpecificStock("f").getShares());
    
    
    
    
  }
  
  @Test
  public void completeAnalysisOnUncertainStock() {
    double[] applePrices = {266.18,266.37,261.78,262.01,263.19,266.29,267.1,265.76,262.64,264.47,261.96,262.2,260.14,259.43,257.24,257.13,257.5,255.82,248.76,243.26,243.29,249.05,246.58,243.58,243.18,239.96,240.51,236.41,235.28,234.37,235.32,235.87,236.21,230.09,227.03,224.4,227.06,227.01,220.82,218.96,224.59,223.97,218.82,219.89,221.03,217.68,218.72,217.73,220.96,222.77,220.7,219.9,218.75,223.09,223.59,216.7,214.17,213.26,213.28,209.19,205.7,208.74,209.01,205.53,204.16,206.49,202.64,212.46,212.64,210.36,210.35,206.5,201.74,202.75,208.97,200.48,200.99,203.43,199.04,197,193.34,204.02,208.43,213.04,208.78,209.68,207.74,207.02,208.67,208.84,207.22,202.59,205.66,203.35,204.5,205.21,203.3,201.75,203.23,201.24,200.02,204.23,204.41,202.73,201.55,197.92,199.74,199.8,195.57,198.58,198.78,199.46,197.87,198.45,193.89,192.74,194.15,194.19,194.81,192.58,190.15,185.22,182.54,179.64,173.3,175.07,178.3,177.38,178.23,178.97,179.66,182.78,186.6,183.09,189,190.08,190.92,188.66,185.72,197.18,200.72};
    double appleEps = 11.89;
    String appleOutlook = "3 Months";
    LearningTool cool = new LearningTool(appleOutlook, applePrices, appleEps);
    
    //assert statements
    assertEquals(cool.getPERatio(), "The P/E Ratio equates the current stock price of a company to its earnings per share. Also known as an earnings multiple, the P/E Ratio tells us the ratio of how many dollars an investor spends on a stock to how many dollars that company earns. The purpose of this metrics is too see if investors are overpaying or underpaying for a stock. Based on the small relative difference between the current P/E Ratio and the historical P/E Ratio, we have determined that currently investors are neither overpaying nor underpaying for the stock relative to history. This is a neutral sign in purchasing a stock.");
    assertEquals(cool.getPrice(), "The price of a company's stock is equivalent to the market capitalization of a company divided by the number of outstanding shares. For example if a company has a market capitalization of 400 million and has 50 million outstanding shares. The purpose of this metric is obviously to determine how much a stock costs, but also to notice trends in this context. Based on the small positive or negative difference between the current price and the historical price, we have determined that currently the stock has neither devaluated nor inflated over this time period. This is a positive sign in purchasing a stock.");
    assertEquals(cool.getMomentum(), "The market momentum of a stock is the net gain or loss of the stock price over a duration can be calcualted as the stock price on the last day subtracted by the stock price on the first day. The purpose of this metric is to define the trend of the stock during a duration Based on the negative difference between the current market momentum and the historical market momentum, we have determined that the stock price is trending downward and is unlikely to appreciate in the near future. This is a negative sign in purchasing a stock.");
    assertEquals(cool.getRSI(), "The relative strength index is a measure of whether over purchasing or underpurchasing are driving the stock price up or driving the stock price down respectively. This metric can be caluclated as 100 - (100 / (average stock price on a gaining day) / (average stock price on a losing day)). The purpose of this metric is to determine if overselling or overbuying is present, which will help determine the future trend of the price.The average relative strength index indicates that investors are neither overselling nor overbuying the stock, meaning the stock price is close to where it should be. From this we cannot infer any short term trend. This is a neutral sign in purchasing a stock.");
    assertEquals(cool.getEMA(), "The exponential moving average is essentially a more sophisticated version of the average stock price over a duration. Instead of taking the simple average, the exponential moving average weights more recent prices in a duration exponentially more than the previous price. THe purpose of this metric is too smooth out the potential noise of the daily price changes and to have the most recent prices more pronounced as they are more likely to contribute to future short term trends. Based on the negative difference between the current EMA and the historical EMA, we have determined that the stock in moving downward more over this time period in comparison to the previous one and is unlikely to have a short term positive trend. This is a negative sign in purchasing a stock.");
    assertEquals(cool.conclusion(), "Putting together our analysis for each metric will determine if we overall believe the stock is likely to have a short term increase, is likely to have a short term decrease, or if we cannot determine the short term trend.Based on the insight we gained from the five metrics, we are unable to determine whether a short term increase or decrease is likely to occur and therefore further research needs to be conducted.");
                        

  }
  
  @Test
  public void completeAnalysisOnBadStock() {
    
  }
}