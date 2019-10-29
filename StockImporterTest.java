import junit.framework.TestCase;

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
  
  public void testGetRecentStockInformation() {
    assertTrue(0.0 ==  StockImporter.getCurrentPrice("This is a false name")); //This should output 0.0, as this is our placeholder for failed api requests
    assertFalse(StockImporter.getCurrentPrice("MSFT")==0.0); //This should output true, as this is a API call that should be successful"
  }
  
}
