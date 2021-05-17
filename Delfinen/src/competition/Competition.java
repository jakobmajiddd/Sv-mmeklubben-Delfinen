package competition;

import main.UI;
import member.CompetitiveMember;

import java.util.ArrayList;

/**
 * @author Martin
 */

public class Competition {
    private String date;
    private String location;
    private Discipline discipline;

    private ArrayList<CompetitiveMember> competitors;
    UI ui = new UI();

    public Competition(String date, String location, Discipline discipline) {
        this.date = date;
        this.location = location;
        this.discipline = discipline;
    }

    void addCompetitor(CompetitiveMember competitor) {
        competitors.add(competitor);
    }

    void removeCompetitor(String name) {
        for (CompetitiveMember c : competitors) {
            if (c.getNAME().equals(name)) {
                competitors.remove(c);
                break;
            }
        }
    }

    void viewCompetitors() {
        for (CompetitiveMember c : competitors) {
            new UI().display(c.toString());
        }

    }
    public void addCompatitions(){

        Competition competition1 = new Competition(ui.getString(), ui.getString(), ui.getDiscipline(ui.getString()));
        ui.display("Enter the date, location and discipline for the competition");
        System.out.println(competition1);
    }

    public String toString() {
        return date + " : " + location + " -> " + discipline;
    }
}
