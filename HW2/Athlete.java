/**
 * Created by djsul on 10/28/2016.
 */

public class Athlete {
    CyclingResult cyclingResult;
    BiathlonResult biathlonResult;
    double sum;
    String name;

    // Athlete creates an athlete using the results of both the Biathlon and the Cycling events, as well as a name
    Athlete(String name, BiathlonResult biathlonResult, CyclingResult cyclingResult){
        this.cyclingResult = cyclingResult;
        this.biathlonResult = biathlonResult;
        this.name = name;
    }

    // totalScore returns the a double of the sum of the scores of the events
    double totalScore() {
        sum = this.cyclingResult.pointsEarned() + this.biathlonResult.pointsEarned();
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
        if (this.totalScore() > athlete.totalScore()) {
            return athlete;
        }
        else return this;
    }

    // betterCyclist2 compares the cycling results of an inputted athlete and the athlete within this field
    // and returns the athlete with the smaller score
    //      uses CyclingResult class to run the checkBetter method within it to compare scores
    Athlete betterCyclist2(Athlete athlete) {
        if(cyclingResult.checkBetter(athlete)) {
            return athlete;
        }
        else return this;
    }

    // Compares the cycling results of all the athletes in the first competition with their results in the second.
    // The method looks for the athlete with the same name in both competition and compares the cycling result.
    // If the score of the second competition's cycling result is less than that of the first, it adds one to the counter.
    int countCyclingImproved(Competition b) {
        int counter = 0;

        for(Athlete a: b.athletes) {
            if(a.name.equals(this.name)) {
                if(this.cyclingResult.pointsEarned() < a.cyclingResult.pointsEarned()){
                    counter++;
                }
            }
        }
        return counter;
    }
}