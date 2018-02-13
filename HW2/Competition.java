/**
 * Created by djsul on 11/6/2016.
 */
import java.util.LinkedList;

public class Competition {
    double totalScore;
    String name;
    LinkedList<Athlete> athletes = new LinkedList<Athlete>();
    int biathlonRounds;

    // constructor for competition
    // takes in a list of athletes and a number of biathlon rounds
    Competition(LinkedList<Athlete> athletes, int biathlonRounds) {
        this.athletes = athletes;
        this.biathlonRounds = biathlonRounds;
    }

    // goes through the competition and adds the athlete to a list if the athlete does not have the same
    // amount of rounds in the biathlon category as there were in the competition
    LinkedList<Athlete> BiathlonDNF() {
        LinkedList<Athlete> dnfAthlete = new LinkedList<Athlete>();

        for (Athlete a : athletes) {
            if (biathlonRounds > a.biathlonResult.totalRounds()) {
                dnfAthlete.add(a);
            }
        }
        return dnfAthlete;
    }

    // takes in a name of an athlete and searches the list of athletes for that name. It then returns the total
    // score of that athlete
    double scoreForAthlete(String name) {
        for (Athlete a : athletes) {
            if (a.name.equals(name)) {
                totalScore = a.totalScore();
            }
        }
        return totalScore;
    }

    // Compares the cycling results of all the athletes in the first competition with their results in the second.
    // The method looks for the athlete with the same name in both competition and compares the cycling result.
    // If the score of the second competition's cycling result is less than that of the first, it adds one to the counter.
    int countCyclingImproved(Competition b) {
        int counter = 0;

        for (Athlete a : athletes) {
            counter = counter + a.countCyclingImproved(b);
        }
        return counter;
    }
}
/**
 For both scoreForAthlete and countCyclingImproved, we could have made a method for both comparing names
 and for running through the list of athletes. We feel as though our code effectively runs through the list
 and is able to answer the questions just as effectively.
 **/