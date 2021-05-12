package member;

import competition.Competition;
import competition.Discipline;
import staff.Coach;

public class CompetitiveMember extends Member {
    private Coach coach;
    private double bestTime;
    private Competition nextCompetition;
    private Discipline discipline;


    CompetitiveMember(String name, int age, String email, String date, Coach coach, Competition nextCompetition, Discipline discipline) {
        super("cm", name, age, email, date);
        this.coach = coach;
        this.nextCompetition = nextCompetition;
        this.discipline = discipline;
    }

    CompetitiveMember(String name, int age, String email, Coach coach, Competition nextCompetition, Discipline discipline) {
        super("cm", name, age, email);
        this.coach = coach;
        this.nextCompetition = nextCompetition;
        this.discipline = discipline;
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

    public String toString() {
        return getNAME() + ", " + "Best time: " + bestTime + ", " + coach;
    }
}
