import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class PortfolioTest extends TestCase {
  public String[] stockNames = new String[] {"Apple,inc.", "Microsoft Corporation", "Tesla Motors"};
  public String[] symbols = new String[]{"AAPL","MSFT","TSLA"};
  public int[] stockAmounts = new int[]{10,2,0};
  public String[] dates = new String[]{"05/25/2016", "02/12/2011", "03/13/2019"};
  public Portfolio p = new Portfolio (this.stockNames, this.symbols, this.stockAmounts, this.dates);
 
  public void testGetStock() {
    assertTrue(p.getSpecificStock("AAPL").getName().equals("Apple,inc."));
    assertTrue(p.getSpecificStock("TSLA").getName().equals("Tesla Motors"));
    assertTrue(p.getSpecificStock("AAPL").getShares() == 10);
    assertTrue(p.getSpecificStock("TSLA").getShares() == 0);
  }
  
  public void testOutputPortfolio() {
    assertTrue(p.outputPortfolio() != null);
    assertTrue(p.outputPortfolio().equals("Apple,inc..AAPL.10.Wed May 25 00:00:00 EDT 2016\nMicrosoft Corporation.MSFT.2.Sat Feb 12 00:00:00 EST 2011\nTesla Motors.TSLA.0.Wed Mar 13 00:00:00 EDT 2019\n"));
    System.out.println(p.outputPortfolio());
  }
    
    
}
  

