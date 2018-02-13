/**
 * Created by djsul on 11/6/2016.
 */
public abstract class AbsResults implements IEvent {
    double time;
    int place;

    AbsResults(double time, int place) {
        this.time = time;
        this.place = place;
    }
}
