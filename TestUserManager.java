import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TestUserManager extends TestCase {
  UserManager um = new UserManager();
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testAddUser() {
    assertTrue(um.addUser("Test name", 12, "PassWoRD"));
    assertFalse(um.addUser("Test name", 12, "PassWoRD"));
  }
  
  public void testGetUser(){
    um.addUser("ian",19,"Test12");
    um.addUser("john", 18, "TestTEst");
    
    assertTrue(um.getUser("tom") == null);
    assertTrue(um.getUser("ian").getAge() == 19);
  }
  
  public void testCheckPassword(){
    assertFalse(um.checkPassword("this will fail"));
    assertFalse(um.checkPassword("THIS WILL FAIL TOO"));
    assertTrue(um.checkPassword("This WiLL NoT FaIl"));
  }
  
}
