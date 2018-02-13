/**
 * Created by djsul on 11/6/2016.
 */
public class MarathonResult extends AbsResults implements IEvent{
    //double time;
    //int place; // irrelevant to points earned

    // constructor for MarathonResult
    // takes in a time and a place and produces a result
    MarathonResult(double time, int place) {
        super(time, place);
    }

    // produces the score of the marathon, where the score is just the time
    public double pointsEarned() {
        return time;
    }
}