/**
 * Created by djsul on 10/31/2016.
 */
public class BiathlonRound {
    double time; // in seconds, run around track
    int targetsHit; // (0-5)

    // BiathlonRound inputs and integer of the number of targets hit (0-5) and a double of time (in sec)
    // to create a round
    BiathlonRound(int targetsHit, double time) {
        this.time = time;
        this.targetsHit = targetsHit;
    }

    // getRoundScore produces the score of an individual BiathlonRound based on time and targets hit
    public double getRoundScore() {
        return (time + ((5 - targetsHit) * 60));
    }
}
