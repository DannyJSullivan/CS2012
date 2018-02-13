/**
 * Created by djsul on 10/30/2016.
 */
public class BiathlonResult implements IEvent {

    BiathlonRound round1;
    BiathlonRound round2;
    BiathlonRound round3;

    double score;

    double rd1;
    double rd2;
    double rd3;

    // BiathlonResult takes in 3 BiathlonRounds and produces a result
    BiathlonResult(BiathlonRound round1, BiathlonRound round2, BiathlonRound round3) {
        this.round1 = round1;
        this.round2 = round2;
        this.round3 = round3;
    }

    // pointsEarned takes in the time from all the events and adds them all together. It then deducts points lost
    // from missing targets and penalizes by 60 seconds for each target missed accordingly. It returns the final score
    // after checking through all targets.
    public double pointsEarned(){
        score = (round1.time + round2.time + round3.time);
        if(round1.targetsHit <= 5) {
            score = score + (5 - round1.targetsHit) * 60;
        }
        if(round2.targetsHit <= 5) {
            score = score + (5 - round2.targetsHit) * 60;
        }
        if(round3.targetsHit <= 5) {
            score = score + (5 - round3.targetsHit) * 60;
        }
        return score;
    }

    // bestRound returns a BiathlonRound that has the best score out of the three within a BiathlonResult.
    // If scores are the same, it will return the earliest of the rounds
    public BiathlonRound bestRound() {
        double rd1 = (round1.time + ((5 - round1.targetsHit) * 60));
        double rd2 = (round2.time + ((5 - round2.targetsHit) * 60));
        double rd3 = (round3.time + ((5 - round3.targetsHit) * 60));

        if(rd1 <= rd2) {
            if (rd1 <= rd3) {
                return round1;
            }
        }
        if(rd2 <= rd1) {
            if (rd2 <= rd3) {
                return round2;
            }
        }
        return round3;
    }
}
