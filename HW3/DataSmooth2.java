import java.util.LinkedList;

class DataSmooth2 {
  DataSmooth2(){}

  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    LinkedList<Double> averages = new LinkedList<>();
    double average;
    double sum = 0;

    for(int i = 1; i < phrs.size() - 1; i++) {
      sum += phrs.get(i).heartRate;
      sum += phrs.get(i-1).heartRate;
      sum += phrs.get(i+1).heartRate;
      average = sum/3;
      averages.add(average);
    }
    averages.addFirst((double)(phrs.get(0).heartRate));
    averages.add((double)(phrs.get(phrs.size()- 1).heartRate));

    return averages;
  }
}