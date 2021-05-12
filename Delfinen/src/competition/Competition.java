package competition;

import main.UI;
import member.CompetitiveMember;
import member.Member;

import java.util.ArrayList;
import java.util.Date;

public class Competition {
    private String date;
    private String location;
    private Discipline discipline;

    private ArrayList<CompetitiveMember> competitors;

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
            new UI().getMessege(c.toString());
        }
    }

    public String toString() {
        return date + " : " + location + " -> " + discipline;
    }
}
