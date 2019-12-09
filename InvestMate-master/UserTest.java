import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class UserTest extends TestCase {
  
  public String[] stockNames = new String[] {"Apple,inc.", "Microsoft Corporation", "Tesla Motors"};
  public String[] symbols = new String[]{"AAPL","MSFT","TSLA"};
  public int[] stockAmounts = new int[]{10,2,0};
  public String[] dates = new String[]{"05/25/2016", "02/12/2011", "03/13/2019"};
  
  Portfolio p = new Portfolio(stockNames, symbols, stockAmounts, dates);
  
  User u = new User("testname",24);
  User k = new User("otherName",15);
  
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testGetName() {
    assertTrue(u.getName().equals("testname"));
  }
  public void testSetName(){
    u.setName("testing");
    assertTrue(u.getName().equals("testing"));
  }
  public void testGetAge(){
    assertTrue(u.getAge() == 24);
  }
  public void testSetAge(){
    u.setAge(18);
    assertTrue(u.getAge() == 18);
  }
  
  //Not sure how to/if it makes sense to test set/create portfolio as they are just setters.
               
}
  

