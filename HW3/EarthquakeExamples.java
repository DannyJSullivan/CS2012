import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();

  Earthquake1 E2 = new Earthquake1();
  LinkedList<Double> threeDates2 = new LinkedList<Double>();
  LinkedList<MaxHzReport> JanReports2 = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));

    threeDates2.add(20151013.0);
    threeDates2.add(10.0);
    threeDates2.add(5.0);
    threeDates2.add(20150120.0);
    threeDates2.add(500.0);
    threeDates2.add(500.0);
    threeDates2.add(45.0);
    threeDates2.add(20150102.0);
    threeDates2.add(75.0);
    JanReports2.add(new MaxHzReport(20150120.0,500.0));
    JanReports2.add(new MaxHzReport(20150102.0,75.0));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }

  @Test
  public void testEQ2() {
    assertEquals(JanReports2, E2.dailyMaxForMonth(threeDates2, 01));
  }


}
