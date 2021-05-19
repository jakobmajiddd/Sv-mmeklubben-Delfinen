package competition;

import UI.UI;
import member.CompetitiveMember;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Martin
 */

public class Competition {
    private CompetitionType type;
    private Date date;
    private String location;
    private Discipline discipline;
    private final int ID;
    private ArrayList<CompetitiveMember> competitors = new ArrayList<>();
    private UI ui = new UI();

    public Competition(CompetitionType type, String date, String location, Discipline discipline) {
        this.type = type;
        this.date = convertStringToDate(date);
        this.location = location;
        this.discipline = discipline;
        this.ID = ui.getValidCompetitionID();

    }

    public Competition(int ID, CompetitionType type, String date, String location, Discipline discipline) {
        this.ID = ID;
        this.type = type;
        this.date = convertStringToDate(date);
        this.location = location;
        this.discipline = discipline;
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

    public ArrayList<CompetitiveMember> getCompetitors() {
        return competitors;
    }

    public void addCompetitor(CompetitiveMember competitor) {
        competitors.add(competitor);
    }

    boolean inCompetition(int id) {
        for (CompetitiveMember c : competitors) {
            if (c.getID() == id) {
                return true;
            }
        }
        return false;
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

    public Discipline getDiscipline() {
        return discipline;
    }

    public Date getDate() {
        return date;
    }

    public void assignPlacements() {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < competitors.size(); i++) {
            nums.add(i+1);
        }

        Collections.shuffle(nums);

        for (int i = 0; i < competitors.size(); i++) {
            competitors.get(i).addPlacement(nums.get(i));
        }
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
