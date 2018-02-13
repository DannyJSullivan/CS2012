import java.util.LinkedList;

class BMI1 {
  BMI1(){}

  public BMISummary bmiReport(LinkedList<PHR> people) {
    LinkedList<String> underweight = new LinkedList<>();
    LinkedList<String> healthy = new LinkedList<>();
    LinkedList<String> overweight = new LinkedList<>();
    LinkedList<String> obese = new LinkedList<>();

    BMISummary report = new BMISummary(underweight, healthy, overweight, obese);

    for(PHR p: people) {
      double BMI = p.weight / (p.height * p.height);

      if (BMI < 18.5) {
        underweight.add(p.name);
      }
      if (BMI < 25 && BMI >= 18.5) {
        healthy.add(p.name);
      }
      if (BMI < 30 && BMI >= 25) {
        overweight.add(p.name);
      }
      if (BMI >= 30) {
        obese.add(p.name);
      }
    }
    return report;
  }
}