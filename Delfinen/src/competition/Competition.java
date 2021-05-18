package competition;

import UI.UI;
import member.CompetitiveMember;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Martin
 */

public class Competition {
    private CompetitionType type;
    private Date date;
    private String location;
    private Discipline discipline;
    private final int ID;
    private static int count;

    private ArrayList<CompetitiveMember> competitors = new ArrayList<>();
    private UI ui = new UI();

    public Competition(CompetitionType type, String date, String location, Discipline discipline) {
        this.type = type;
        this.date = convertStringToDate(date);
        this.location = location;
        this.discipline = discipline;
        count++;
        ID = count;
    }

    public Competition(int ID, CompetitionType type, String date, String location, Discipline discipline) {
        this.ID = ID;
        this.type = type;
        this.date = convertStringToDate(date);
        this.location = location;
        this.discipline = discipline;
        count++;
    }

    public Date convertStringToDate(String sDate) {
        try {
            return new SimpleDateFormat("d/MM/y").parse(sDate);
        } catch (ParseException e) {
            return Calendar.getInstance().getTime();
        }
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

    public String dateFormatted() {
        DateFormat df = new SimpleDateFormat("d/MM/y");
        return df.format(date);
    }

    public String toFileFormat() {
        return  ID
                + "_" + type.toString()
                + "_" + dateFormatted()
                + "_" + location
                + "_" + discipline
                + "_" + fileCompetitorID();
    }

    public String toString() {
        return dateFormatted() + " : " + location + " -> " + discipline + ", ID# " + getID();
    }
}
