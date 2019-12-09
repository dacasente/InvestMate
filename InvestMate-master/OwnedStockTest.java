import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class OwnedStockTest extends TestCase {
  OwnedStock s = new OwnedStock("Tesla Motors", "TSLA", 10, "05/25/2018");
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testGetName() {
    assertTrue(s.getName().equals("Tesla Motors"));
  }
  
  public void testSetName(){
    s.setName("Tesla Motors inc.");
    assertTrue(s.getName().equals("Tesla Motors inc."));
  }
  
  public void testGetTicker(){
    assertTrue(s.getTicker().equals("TSLA"));
  }
  
  public void testSetTicker(){
    s.setTicker("TM");
    assertTrue(s.getTicker().equals("TM"));
  }
  
  public void testGetShares(){
    assertTrue(s.getShares() == 10);
  }
  
  public void testSetShares(){
    s.setShares(12);
    assertTrue(s.getShares() == 12);
  }
  
  public void testRemoveShares(){
    s.removeShares(4);
    assertTrue(s.getShares() == 6);
    assertFalse(s.removeShares(7));
  }
  
  public void testGetDatePurchased(){
    assertTrue(s.getPurchased().toString().equals(s.convertDate("05/25/2018").toString()));
  }
  
  public void testSetPurchased(){
    s.setPurchased(s.convertDate("05/22/2013"));
    assertTrue(s.getPurchased().toString().equals(s.convertDate("05/22/2013").toString()));
  }
  
  public void testConvertDate(){
    assertTrue(s.convertDate("this won't work")==null);
  }
    
  
}     
