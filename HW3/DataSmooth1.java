import java.util.LinkedList;

class DataSmooth1 {
  DataSmooth1(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    LinkedList<Double> smooth = new LinkedList<>();
    double average = 0;

    smooth.add((double)(phrs.get(0).heartRate));
    for(int i = 1; i < phrs.size() - 1; i++) {
      average = (phrs.get(i).heartRate + phrs.get(i - 1).heartRate + phrs.get(i + 1).heartRate) / 3;
      smooth.add(average);
    }
    smooth.add((double)(phrs.get(phrs.size()- 1).heartRate));

    return smooth;
  }
}