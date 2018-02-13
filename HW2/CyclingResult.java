/**
 * Created by djsul on 10/30/2016.
 */
public class CyclingResult extends AbsResults implements IEvent {

    //double time; // in seconds
    //int place; // 1 for 1st, 2 for 2nd, etc.

    // CyclingResult takes in a double and an integer and creates a final result
     CyclingResult(double time, int place) {
        super(time, place);
    }

    // pointsEarned returns the total time of a CyclingResult, which is equivalent to the amount of points earned.
    // If the cyclist comes in first, 10 seconds is deducted from their time, second deducts 7 sec, and third deducts 5
    public double pointsEarned(){
        if(place == 1) {
            time = time - 10;
        }
        else if(place == 2) {
            time = time - 7;
        }
        else if(place == 3) {
            time = time - 5;
        }
        else {
            time = time;
        }
        return time;
    }

    // checkBetter inputs an Athlete and produces true if the inputted athlete has a better (lower) score than
    // the athlete in the field, otherwise, it produces false.
    public boolean checkBetter(Athlete athlete) {
        if (pointsEarned() > athlete.cyclingResult.pointsEarned()) {
            return true;
        }
        return false;
    }
}