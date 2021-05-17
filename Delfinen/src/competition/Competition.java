package competition;

import UI.UI;
import member.CompetitiveMember;

import java.util.ArrayList;

/**
 * @author Martin
 */

public class Competition {
    private CompetitionType type;
    private String date;
    private String location;
    private Discipline discipline;
    private final int ID;
    private static int count;

    private ArrayList<CompetitiveMember> competitors = new ArrayList<>();
    private UI ui = new UI();

    public Competition(CompetitionType type, String date, String location, Discipline discipline) {
        this.type = type;
        this.date = date;
        this.location = location;
        this.discipline = discipline;
        count++;
        ID = count;
    }

    public CompetitionType getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    void addCompetitor(CompetitiveMember competitor) {
        competitors.add(competitor);
    }

    void removeCompetitor() {
        ui.display("ID: ");
        int id = ui.getValidInt("Invalid");

        if (inCompetition(id)) {
            for (CompetitiveMember c : competitors) {
                if (c.getID() == id) {
                    competitors.remove(c);
                    break;
                }
            }
        } else {
            ui.display("ID not found");
        }
    }

    boolean inCompetition(int id) {
        for (CompetitiveMember c : competitors) {
            if (c.getID() == id) {
                return true;
            }
        }
        return false;
    }

    void viewCompetitors() {
        for (CompetitiveMember c : competitors) {
           ui.display(c.toString());
        }
    }

    public String fileCompetitorID() {
        StringBuilder text = new StringBuilder();
        for (CompetitiveMember c : competitors) {
            text.append(c.getID());
            text.append("_");
        }
        return text.toString();
    }

    public String toFileFormat() {
        return type.toString()
                + "_" + date
                + "_" + location
                + "_" + discipline
                + "_" + fileCompetitorID();
    }

    public String toString() {
        return date + " : " + location + " -> " + discipline + ", ID# " + getID();
    }
}
