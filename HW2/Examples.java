import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class Examples {

    public Examples(){}

    @Test
    public void dummyTest() {

    }

    /**
    //BiathlonRound(int targetsHit, double time)
    BiathlonRound firstRound = new BiathlonRound(5, 1);
    BiathlonRound secondRound = new BiathlonRound(3, .5);
    BiathlonRound thirdRound = new BiathlonRound(0, 0);
    BiathlonRound bestRound2 = new BiathlonRound(5, .5);
    BiathlonRound bestRound3 = new BiathlonRound(5, .2);

    BiathlonResult testGuy = new BiathlonResult(firstRound, secondRound, thirdRound);
    BiathlonResult testGuy2 = new BiathlonResult(firstRound, bestRound2, thirdRound);
    BiathlonResult testGuy3 = new BiathlonResult(firstRound, secondRound, bestRound3);

    @Test
    public void testBestRoundFirst() {
        assertEquals(firstRound, testGuy.bestRound());
    }

    @Test
    public void testBestRoundSecond() {
        assertEquals(bestRound2, testGuy2.bestRound());
    }

    @Test
    public void testBestRoundThird() {
        assertEquals(bestRound3, testGuy3.bestRound());
    }

    @Test
    public void testTotalScore() {
        assertEquals(421.5, testGuy.pointsEarned(), .1); // == 1 + 120.5 + 300
    }

    //CyclingResult(double time, int place)
    CyclingResult firstPlace = new CyclingResult(10, 1);
    CyclingResult secondPlace = new CyclingResult(10.5, 2);
    CyclingResult thirdPlace = new CyclingResult(20, 3);
    CyclingResult fourthPlace = new CyclingResult(20.5, 4);

    @Test
    public void testFirstPlace() {
        assertEquals(0, firstPlace.pointsEarned(), .1); // == 0
    }

    @Test
    public void testSecondPlace() {
        assertEquals(3.5, secondPlace.pointsEarned(), .1); // == 3.5
    }

    @Test
    public void testThirdPlace() {
        assertEquals(15, thirdPlace.pointsEarned(), .1); // == 15
    }

    @Test
    public void testFourthPlace() {
        assertEquals(20.5, fourthPlace.pointsEarned(), .1); // == 20.5
    }

    Athlete testGuyA = new Athlete(testGuy, firstPlace);
    Athlete testGuyB = new Athlete(testGuy2, secondPlace);
    Athlete testGuyC = new Athlete(testGuy3, thirdPlace);

    @Test
    public void testHasBeaten() {
        testGuyA.hasBeaten(testGuyB);
    }

    @Test
    public void testHasBeaten2() {
        testGuyA.hasBeaten(testGuyC);
    }

    @Test
    public void testBetterCyclist1() {
        testGuyA.betterCyclist1(testGuyB);
    }

    @Test
    public void testBetterCyclist2() {
        testGuyA.betterCyclist2(testGuyC);
    }
    **/

    // HW2 TESTS

            BiathlonRound round1 = new BiathlonRound(5, 1);
            BiathlonRound round2 = new BiathlonRound(4, 2);
            BiathlonRound round3 = new BiathlonRound(3, 3);

            BiathlonRound round4 = new BiathlonRound(2, 4);
            BiathlonRound round5 = new BiathlonRound(1, 5);
            BiathlonRound round6 = new BiathlonRound(0, 6);
            BiathlonRound round7 = new BiathlonRound(0, 10);

            LinkedList<BiathlonRound> rounds123 = new LinkedList<BiathlonRound>();
            LinkedList<BiathlonRound> rounds456 = new LinkedList<BiathlonRound>();
            LinkedList<BiathlonRound> dnfRounds = new LinkedList<BiathlonRound>();

        public void addRounds() {
            rounds123.add(round1);
            rounds123.add(round2);
            rounds123.add(round3);

            rounds456.add(round4);
            rounds456.add(round5);
            rounds456.add(round6);

            dnfRounds.add(round7);
        }

        BiathlonResult result1 = new BiathlonResult(rounds123);
        BiathlonResult result2 = new BiathlonResult(rounds456);
        BiathlonResult roundsDNF = new BiathlonResult(dnfRounds);

        CyclingResult cResult1 = new CyclingResult(1, 1);
        CyclingResult cResult2 = new CyclingResult(2, 2);
        CyclingResult cResult3 = new CyclingResult(3, 3);
        CyclingResult cResult4 = new CyclingResult(4, 4);

        Athlete athlete1 = new Athlete("Guy", result1, cResult1);
        Athlete athlete2 = new Athlete("Dude", result2, cResult2);
        Athlete dnfAthlete1 = new Athlete("Fail", roundsDNF, cResult1);
        Athlete newAthlete1 = new Athlete("Guy", result2, cResult2);
        Athlete newAthlete2 = new Athlete("Dude", result1, cResult1);
        Athlete dnfAthlete2 = new Athlete("Fail", roundsDNF, cResult4);

        LinkedList<Athlete> athletes1 = new LinkedList<Athlete>();
        LinkedList<Athlete> athletes2 = new LinkedList<Athlete>();

        public void addAthletes() {
            athletes1.add(athlete1);
            athletes1.add(athlete2);
            athletes1.add(dnfAthlete1);
            athletes2.add(newAthlete1);
            athletes2.add(newAthlete2);
            athletes2.add(dnfAthlete2);
        }

        Competition comp1 = new Competition(athletes1, 3);
        Competition comp2 = new Competition(athletes2, 3);

    @Test
    public void testTotalRounds() {
        addRounds();
        addAthletes();
        assertEquals(3, comp1.biathlonRounds);
    }

    @Test
    public void testIndiviualBiathlonRound() {
        addRounds();
        addAthletes();
        assertEquals(1, round1.getRoundScore(), .01);
    }

    @Test
    public void testTotalBiathlonScore() {
        addRounds();
        addAthletes();
        assertEquals(123, result1.pointsEarned(), .01);
    }

    @Test
    public void testBestRound() {
        addRounds();
        addAthletes();
        assertEquals(result1.bestRound(), round1);
        assertEquals(result2.bestRound(), round4);
        assertEquals(roundsDNF.bestRound(), round7);
    }

    @Test
    public void testBiathlonDNF() {
        addRounds();
        addAthletes();
        LinkedList<Athlete> dnfAthletes1 = new LinkedList<>();
        LinkedList<Athlete> dnfAthletes2 = new LinkedList<>();
        dnfAthletes1.add(dnfAthlete1);
        dnfAthletes2.add(dnfAthlete2);
        assertEquals(dnfAthletes1, comp1.BiathlonDNF());
        assertEquals(dnfAthletes2, comp2.BiathlonDNF());
    }

    @Test
    public void testScoreForAthlete() {
        addRounds();
        addAthletes();
        assertEquals(114, comp1.scoreForAthlete("Guy"), .01);
        assertEquals(301, comp1.scoreForAthlete("Dude"), .01);
        assertEquals(291, comp1.scoreForAthlete("Fail"), .01);
    }

    @Test
    public void testCyclingImproved() {
        addRounds();
        addAthletes();
        assertEquals(2, comp1.countCyclingImproved(comp2));
        assertEquals(1, comp2.countCyclingImproved(comp1));
        assertEquals(0, comp2.countCyclingImproved(comp2));
    }
}