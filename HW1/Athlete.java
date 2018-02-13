/**
 * Created by djsul on 10/28/2016.
 */

public class Athlete {
    CyclingResult cResult;
    BiathlonResult bResult;
    double sum;

    // Athlete creates an athlete using the results of both the Biathlon and the Cycling events
    Athlete(BiathlonResult bResult, CyclingResult cResult){
        this.cResult = cResult;
        this.bResult = bResult;
    }

    // totalScore returns the a double of the sum of the scores of the events
    double totalScore() {
        sum = this.cResult.pointsEarned() + this.bResult.pointsEarned();
        return sum;
    }

    // hasBeaten compares the score of the athlete in this field to an inputed athlete and returns true if the
    // inputted athlete has a lower score and false if the inputted athlete has a higher score
    boolean hasBeaten(Athlete athlete) {
        if (totalScore() > athlete.totalScore()) {
            return true;
        }
        return false;
    }

    // betterCyclist1 compares the cycling results of an inputted athlete and the athlete within this field
    // and returns the athlete with the smaller score
    Athlete betterCyclist1(Athlete athlete) {
        if (cResult.pointsEarned() > athlete.cResult.pointsEarned()) {
            return athlete;
        }
        else return this;
    }

    // betterCyclist2 compares the cycling results of an inputted athlete and the athlete within this field
    // and returns the athlete with the smaller score
    //      uses CyclingResult class to run the checkBetter method within it to compare scores
    Athlete betterCyclist2(Athlete athlete) {
        if(cResult.checkBetter(athlete)) {
            return athlete;
        }
        else return this;
    }
}