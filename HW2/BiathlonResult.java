/**
 * Created by djsul on 10/30/2016.
 */
import java.util.LinkedList;

public class BiathlonResult implements IEvent {

    /**
    BiathlonRound round1;
    BiathlonRound round2;
    BiathlonRound round3;

    // BiathlonResult takes in 3 BiathlonRounds and produces a BiathlonResult
    BiathlonResult(BiathlonRound round1, BiathlonRound round2, BiathlonRound round3) {
        this.round1 = round1;
        this.round2 = round2;
        this.round3 = round3;
    }
     **/

    LinkedList<BiathlonRound> listBRounds = new LinkedList<>();

    //BiathlonResult takes in a list of BiathlonRounds and produces a BiathlonResult
    BiathlonResult(LinkedList listBRounds) {
        this.listBRounds = listBRounds;
    }

    // pointsEarned takes in the time from all the events and adds them all together. It then deducts points lost
    // from missing targets and penalizes by 60 seconds for each target missed accordingly. It returns the final score
    // after checking through all targets.
    /**
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
     **/

    // pointsEarned takes in the time from all the events and adds them all together. It then deducts points lost
    // from missing targets and penalizes by 60 seconds for each target missed accordingly. It returns the final score
    // after checking through all targets.
    public double pointsEarned() {
        double score = 0;

        for(BiathlonRound r: listBRounds) {
            score =+ r.getRoundScore();
        }
        return score;
    }


    /**
    // bestRound returns a BiathlonRound that has the best score out of the three within a BiathlonResult.
    // If scores are the same, it will return the earliest of the rounds
    public BiathlonRound bestRound1() {
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
     **/

    // bestRound returns a BiathlonRound that has the best score out of the three within a BiathlonResult.
    // If scores are the same, it will return the earliest of the rounds
    public BiathlonRound bestRound() {
        BiathlonRound bestRound = new BiathlonRound(0, 999999999);
        double bestScore = 999999999;

        for(BiathlonRound r: listBRounds) {
            if(r.getRoundScore() < bestScore) {
                bestScore = r.getRoundScore();
                bestRound = r;
            }
        }
        return bestRound;
    }

    // returns the size of the list of biathlon rounds
    int totalRounds() {
        return listBRounds.size();
    }
}