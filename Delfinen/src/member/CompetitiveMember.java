package member;

import competition.Competition;
import staff.Coach;

import java.util.Date;

public class CompetitiveMember extends Member {
    private Coach coach;
    private double bestTime;
    private Competition nextCompetition;

    CompetitiveMember(String name, int age, String email, Date date, Coach coach, Competition nextCompetition) {
        super("cm", name, age, email, date);
        this.coach = coach;
        this.nextCompetition = nextCompetition;
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public Competition getNextCompetition() {
        return nextCompetition;
    }

    public void setNextCompetition(Competition nextCompetition) {
        this.nextCompetition = nextCompetition;
    }

    @Override
    public String toFileFormat() {
        return getFILE_ID()
                + "_" + getNAME()
                + "_" + getAGE()
                + "_" + getEMAIL()
                + "_" + getLastPaymentDate()
                + "_" + coach.toString()
                + "_" + nextCompetition;
    }
}
