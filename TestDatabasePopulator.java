import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TestDatabasePopulator extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testGetNames() {
    assertTrue(DatabasePopulator.getNames() instanceof String[]);
  }
  
  public void testParseCSV() {
    try{
    assertTrue(DatabasePopulator.parseCSVs() instanceof String[]);
    }
    catch(Exception e){
      System.out.println("files not present, failed");
    }
  }
  
  public void testGetCurrent(){
    assertTrue(DatabasePopulator.getCurrentPrice() instanceof Float[]);
  }
  
  public void testGetHistorical(){
    assertTrue(DatabasePopulator.getHistoricalPrices() instanceof Float[][]);
  }
  
  
  
}
