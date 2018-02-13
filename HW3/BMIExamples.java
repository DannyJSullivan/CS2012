import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class BMIExamples {
  BMI1 B1 = new BMI1();
  BMI2 B2 = new BMI2();
  LinkedList<PHR> PHR1 = new LinkedList<PHR>();
  LinkedList<PHR> PHR2 = new LinkedList<PHR>();
  
  public BMIExamples(){
    PHR1.add(new PHR("Eugene", 2, 60, 77));
    PHR1.add(new PHR("Marty", 1.55, 58.17, 56));
    PHR1.add(new PHR("Rai", 1.8, 55, 84));
    PHR1.add(new PHR("Nicky", 1.5, 100, 64));


    //height, weight, heartrate
    PHR2.add(new PHR("Guy", 1, 2, 3)); //underweight
    PHR2.add(new PHR("Underweight", 18.4, 2, 124)); //underweight
    PHR2.add(new PHR("Dude", 18.5, 2, 50)); //healthy
    PHR2.add(new PHR("Mister", 25, 2, 50)); //overweight
    PHR2.add(new PHR("Person", 30, 2, 99999)); //obese
  }
  
  @Test
  public void instructorTestBMI() {
    assertEquals(new BMISummary(new LinkedList<String>(Arrays.asList("Eugene", "Rai")),
                                new LinkedList<String>(Arrays.asList("Marty")),
                                new LinkedList<String>(),
                                new LinkedList<String>(Arrays.asList("Nicky"))),
                 B1.bmiReport(PHR1));
  }

  @Test
  public void testBMI() {
    assertEquals(new BMISummary (new LinkedList<String>(Arrays.asList("Guy", "Underweight")),
                                new LinkedList<String>(Arrays.asList("Dude")),
                                new LinkedList<String>(Arrays.asList("Mister")),
                                new LinkedList<String>(Arrays.asList("Person"))),
            B2.bmiReport(PHR2));
  }
}
