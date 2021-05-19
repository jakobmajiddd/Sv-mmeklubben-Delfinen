package member;

import competition.Discipline;
import java.util.ArrayList;

/**
 * @author Martin
 */

public class CompetitiveMember extends Member {
    private double bestTime;
    private final Discipline DISCIPLINE;
    private ArrayList<Integer> competitionPlacements = new ArrayList<>();

    public CompetitiveMember(String name, int age, String email, Discipline discipline) {
        super("CM", name, age, email);
        this.DISCIPLINE = discipline;
    }

    // File loading
    public CompetitiveMember(int ID, String name, int age, String email, String date, Discipline discipline, double bestTime) {
        super(ID, "CM", name, age, email, date);
        this.DISCIPLINE = discipline;
        this.bestTime = bestTime;
    }

    public void addPlacement(int placement) {
        competitionPlacements.add(placement);
    }

    public double averagePlacement() {
        double sum = 0;
        for (int i : competitionPlacements) {
            sum += i;
        }
        return sum / competitionPlacements.size();
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public Discipline getDISCIPLINE() {
        return DISCIPLINE;
    }

    public String getPlacements() {
        StringBuilder placements = new StringBuilder();
        for (int i : competitionPlacements) {
            placements.append(i);
            placements.append("_");
        }
        return placements.toString();
    }

    @Override
    public String toFileFormat() {
        return getID()
          + "_" + getFILE_ID()
                + "_" + getNAME()
                + "_" + getAGE()
                + "_" + getEMAIL()
                + "_" + dateFormatted()
                + "_" + DISCIPLINE
                + "_" + bestTime
                + "_" + getPlacements();

    }

    public String toString() {
        return    "ID: #" + getID()
                + ", Name: " + getNAME()
                + ", Age: " + getAGE()
                + " - Next payment date: " + dateFormatted()
                + " -> Type: " + getFILE_ID()
                + ", Discipline: " + DISCIPLINE;

               // + ", Team: " + team.getTeamName();
    }

    public String competitiveStats() {
        return    "ID: #" + getID()
                + ", Name: " + getNAME()
                + ", Discipline: " + DISCIPLINE
                + ", Best time: " + bestTime
                + ", Average competition placement: " + averagePlacement();
    }
}
