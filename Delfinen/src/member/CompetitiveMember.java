package member;


import competition.Competition;
import competition.Discipline;
import staff.Coach;


public class CompetitiveMember extends Member implements Comparable<CompetitiveMember> {
    private Coach coach;
    private double bestTime;
    private Competition nextCompetition;
    private Discipline discipline;

    public CompetitiveMember(String name, int age, String email, Discipline discipline) {
        super("CM", name, age, email);
        this.discipline = discipline;
    }

    // File loading
    public CompetitiveMember(int ID, String name, int age, String email, String date, Coach coach, Competition nextCompetition, Discipline discipline) {
        super(ID, "CM", name, age, email, date);
        this.coach = coach;
        this.nextCompetition = nextCompetition;
        this.discipline = discipline;
    }

    public void assignCoach(Coach coach) {
        this.coach = coach;
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
        return    "ID: #" + getID()
                + ", Name: " + getNAME()
                + ", Age: " + getAGE()
                + " - Last payment date: " + getLastPaymentDate()
                + " -> Type: " + getFILE_ID()
                + ", Discipline: " + discipline
                + ", Coach: " + coach;
    }

    @Override
    public int compareTo(CompetitiveMember c) {
        return Double.compare(c.getAGE(), getAGE());
    }
}

