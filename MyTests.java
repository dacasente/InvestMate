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
}