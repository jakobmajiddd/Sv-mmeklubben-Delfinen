package member;


import competition.Competition;
import competition.Discipline;
import competition.Team;

/**
 * @author Martin
 */

public class CompetitiveMember extends Member {
    private Team team;
    private double bestTime;
    private Competition nextCompetition;
    private Discipline discipline;

    public CompetitiveMember(String name, int age, String email, Discipline discipline) {
        super("CM", name, age, email);
        this.discipline = discipline;
    }

    // File loading
    public CompetitiveMember(int ID, String name, int age, String email, String date, Competition nextCompetition, Discipline discipline) {
        super(ID, "CM", name, age, email, date);
        this.nextCompetition = nextCompetition;
        this.discipline = discipline;
    }

    public void assignTeam(Team team) {
        this.team = team;
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

    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toFileFormat() {
        return  getFILE_ID()
                + "_" + getNAME()
                + "_" + getAge()
                + "_" + getEMAIL()
                + "_" + dateFormatted()
                + "_" + nextCompetition;
    }

    public String toString() {
        return    "ID: #" + getID()
                + ", Name: " + getNAME()
                + ", Age: " + getAge()
                + " - Next payment date: " + getNextPaymentDate()
                + " -> Type: " + getFILE_ID()
                + ", Discipline: " + discipline
                + ", Team: " + team.getTeamName();
    }

    public String competitiveStats() {
        return    "ID: #" + getID()
                + ", Name: " + getNAME()
                + ", Discipline: " + discipline
                + ", Best time: " + bestTime;
    }
}
