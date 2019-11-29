import junit.framework.TestCase;
import java.util.ArrayList;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class StockImporterTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  
  public void testGetCurrentPrice() {
    assertTrue(0.0 ==  StockImporter.getCurrentPrice("This is a false name")); //This should output 0.0, as this is our placeholder for failed api requests
    assertFalse(StockImporter.getCurrentPrice("MSFT")==0.0); //This should output true, as this is a API call that should be successful"
  }
  
  public void testGetStockInfo(){
    assertTrue(StockImporter.getStockInfo("MSFT") instanceof String[]);
    assertTrue(StockImporter.getStockInfo("MSFT")[0].equals("MSFT"));
    assertTrue(StockImporter.getStockInfo("MSFT")[1].equals("Microsoft Corporation"));
    assertTrue(StockImporter.getStockInfo("MSFT")[2].equals("Equity"));
    assertTrue(StockImporter.getStockInfo("MSFT")[3].equals("United States"));
    assertTrue(StockImporter.getStockInfo("MSFT")[7].equals("USD"));
  }
  
  public void testGetStockList(){
    assertTrue(StockImporter.getStockList("MSFT") instanceof ArrayList<?>);
    assertTrue(StockImporter.getStockList("This should fail and return null") == null);
  }
  
  public void testGetStockSymbol(){
    assertTrue(StockImporter.getStockSymbol("Microsoft") instanceof String);
    assertTrue(StockImporter.getStockSymbol("Microsoft").equals("MSFT"));
    assertTrue(StockImporter.getStockSymbol("This shouldn't work, it should return null") == null);
  }
  
  public void testGetStockName(){
    assertTrue(StockImporter.getStockName("Microsoft") instanceof String);
    assertTrue(StockImporter.getStockName("Microsoft").equals("Microsoft Corporation"));
    assertTrue(StockImporter.getStockName("This shouldn't work, it should return null") == null);
  }
  
  public void testGetStockType(){
    assertTrue(StockImporter.getStockType("Microsoft") instanceof String);
    assertTrue(StockImporter.getStockType("Microsoft").equals("Equity"));
    assertTrue(StockImporter.getStockType("This shouldn't work, it should return null") == null);
  }
  
  public void testGetStockLocale(){
    assertTrue(StockImporter.getStockLocale("Microsoft") instanceof String);
    assertTrue(StockImporter.getStockLocale("Microsoft").equals("United States"));
    assertTrue(StockImporter.getStockLocale("This shouldn't work, it should return null") == null);
  }
  public void testGetStockCurrency(){
    assertTrue(StockImporter.getStockCurrency("Microsoft") instanceof String);
    assertTrue(StockImporter.getStockCurrency("Microsoft").equals("USD"));
    assertTrue(StockImporter.getStockCurrency("This shouldn't work, it should return null") == null);
  }
}
  
