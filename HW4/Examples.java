import java.util.LinkedList;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
  // customize here, or create multiple monitors with different parameter lists
  SecurityMonitor SM = 
    new SecurityMonitor(new LinkedList<IPattern>(Arrays.asList(new SuspiciousWebPattern())));
  // use this fixed set of usernames -- it is what we have in all the logs
  LinkedList<String> usernames = new LinkedList<String>(Arrays.asList("root","kathi", "simmon", "jordan"));
  
  public Examples() {
    // reset the queue between test cases
    SM.clearQueue();
    // populate the queue based on a specific log
    SM.runLogFile("webrequestlog.txt", usernames);
  }
  
  // check whether the webrequest sample yields a single alert (as it should)
  @Test
  public void checkWebRequestAlerts() {
    SM.runLogFile("./src/loginLog.txt", usernames);
    assertEquals(1, SM.numAlerts());
    SM.clearQueue();
  }

  @Test
  public void checkEqualsTo() {
    Alert alert1 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    assertTrue(alert1.equals(alert2));
  }

  @Test
  public void checkEqualsToFalse() {
    Alert alert1 = new Alert("test", 7, AbsEvent.FILE_SAVED);
    Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    assertFalse(alert1.equals(alert2));
  }

  @Test
  public void checkEqualsToFalse2() {
    Alert alert1 = new Alert("test1", 8, AbsEvent.FILE_SAVED);
    Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    assertFalse(alert1.equals(alert2));
  }

  @Test
  public void checkEqualsToFalse3() {
    Alert alert1 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    Alert alert2 = new Alert("test1", 7, AbsEvent.LOGIN);
    assertFalse(alert1.equals(alert2));
  }

  @Test
  public void checkCompareToZero() {
    Alert alert1 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    assertEquals(0, alert1.compareTo(alert2));
  }

  @Test
  public void checkCompareToNeg() {
    Alert alert1 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    Alert alert2 = new Alert("test1", 5, AbsEvent.FILE_SAVED);
    assertEquals(-1, alert1.compareTo(alert2));
  }

  @Test
  public void checkCompareToPos() {
    Alert alert1 = new Alert("test1", 5, AbsEvent.FILE_SAVED);
    Alert alert2 = new Alert("test1", 7, AbsEvent.FILE_SAVED);
    assertEquals(1, alert1.compareTo(alert2));
  }

  @Test
  public void testLogInAlert1() {
    SM.runLogFile("./src/loginLog.txt", usernames);
    assertEquals(1, SM.numAlerts());
    SM.clearQueue();
  }

  @Test
  public void testLogInAlert2() {
    SM.runLogFile("./src/loginLog2.txt", usernames);
    assertEquals(3, SM.numAlerts());
    SM.clearQueue();
  }

  @Test
  public void testLargeLog1() {
    SM.runLogFile("./src/largeLog1.txt", usernames);
    assertEquals(3, SM.numAlerts());
    SM.clearQueue();
  }

  @Test
  public void testLargeLog2() {
    SM.runLogFile("./src/largestLog.txt", usernames);
    assertEquals(5, SM.numAlerts());
    SM.clearQueue();
  }
}