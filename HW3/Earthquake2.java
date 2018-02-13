import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }



  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxHzReport> results = new LinkedList<>();

    for(int i = 0; i < data.size(); i++) {
      LinkedList<Double> findMax = new LinkedList<>();
      double days = 0;
      double max = 0;

      if(isDate((double) data.get(i))) {
        days = extractMonth(data.get(i));
        for(int j = i++; j < data.size(); j++) {
          if(data.get(j) <= 500) {
            findMax.add(data.get(j));
          }
        }
        for(Double d: findMax) {
          if(d > max) {
            max = d;
          }
        }
        results.add(new MaxHzReport(days, max));
      }
    }
    return results;
  }
}