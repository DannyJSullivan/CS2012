import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples {  
  LinkedList<PHR> PHR1 = new LinkedList<PHR>();
  LinkedList<PHR> PHR2 = new LinkedList<PHR>();
  LinkedList<PHR> PHR3 = new LinkedList<PHR>();
  LinkedList<PHR> PHR4 = new LinkedList<PHR>();
  LinkedList<Double> PHR1Results = new LinkedList<Double>();
  LinkedList<Double> PHR2Results = new LinkedList<Double>();
  LinkedList<Double> PHR3Results = new LinkedList<Double>();
  LinkedList<Double> PHR4Results = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  DataSmooth1 D2 = new DataSmooth1();
  DataSmooth1 D3 = new DataSmooth1();
  DataSmooth1 D4 = new DataSmooth1();
  
  public DataSmoothExamples() {
    // four sample PHRs
    PHR1.add(new PHR("Andy", 1.8, 55, 96));
    PHR1.add(new PHR("Jill", 2, 75, 102));
    PHR1.add(new PHR("Ming", 1.7, 60, 87));
    PHR1.add(new PHR("Sophia", 1.8, 63, 105));

    // the smoothing results on the sample PHRs
    PHR1Results.add(96.0);
    PHR1Results.add(95.0);  // average of 96, 102, 87
    PHR1Results.add(98.0);  // average of 102, 87, 105
    PHR1Results.add(105.0);

    PHR2.add(new PHR("Bob", 0, 0, 0));
    PHR2.add(new PHR("Fred", 0, 25, 46));
    PHR2.add(new PHR("Joe", 500, 900, 8954));
    PHR2.add(new PHR("Guy", 5, 25, 0));

    PHR2Results.add(0.0);
    PHR2Results.add(3000.0);  // average of 96, 102, 87
    PHR2Results.add(3000.0);  // average of 102, 87, 105
    PHR2Results.add(0.0);

    PHR3.add(new PHR("Andy", 1.8, 55, 100));
    PHR3.add(new PHR("Jill", 2, 75, 200));
    PHR3.add(new PHR("Ming", 1.7, 60, 300));

    PHR3Results.add(200.0);

    PHR4.add(new PHR("Andy", 1.8, 55, 100));
    PHR4.add(new PHR("Jill", 2, 75, 200));
    PHR4.add(new PHR("Ming", 1.7, 60, 300));
    PHR4.add(new PHR("Andy", 1.8, 55, 100));
    PHR4.add(new PHR("Jill", 2, 75, 200));
    PHR4.add(new PHR("Ming", 1.7, 60, 300));

    PHR4Results.add(100.0);
    PHR4Results.add(200.0);
    PHR4Results.add(200.0);
    PHR4Results.add(200.0);
    PHR4Results.add(200.0);
    PHR4Results.add(200.0);
    PHR4Results.add(200.0);
    PHR4Results.add(300.0);
  }
  
  @Test
  public void instructorTestDS() {
    assertEquals(PHR1Results,D1.dataSmooth(PHR1));
  }

  @Test
  public void testDS() {
    assertEquals(PHR2Results,D2.dataSmooth(PHR2));
  }

  @Test
  public void testDS2() {
    assertEquals(PHR3Results,D3.dataSmooth(PHR3));
  }

  @Test
  public void testDS3() {
    assertEquals(PHR4Results,D4.dataSmooth((PHR4)));
  }

}