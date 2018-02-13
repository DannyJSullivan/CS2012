import java.util.LinkedList;

class Earthquake1 {
  Earthquake1() {
  }

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int) anum > 10000000;
  }

  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) {
    return ((int) dateNum % 10000) / 100;
  }

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxHzReport> dailyMax = new LinkedList<>();

    for (int i = 0; i < data.size(); i++) {

      if (data.get(i) > 500) {
        if ((int) ((data.get(i) / 100) % 100) == month) {
          double days = data.get(i);
          double max = data.get(i+1);

          for (int j = i++; j < data.size(); j++) {
            if (data.get(j) <= 500) {
              if (data.get(j) > max) {
                max = data.get(j);
              }
            }
            if (data.get(j) > 500) {
              break;
            }
          }
          dailyMax.add(new MaxHzReport(days, max));
        }
      }
    }
    return dailyMax;
  }
}

