package competition;

import UI.UI;
import files.FileFormat;
import member.CompetitiveMember;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Martin
 */

public class Competition implements FileFormat {
    private final Type COMPETITION_TYPE;
    private final Date DATE;
    private final String LOCATION;
    private final Discipline DISCIPLINE;
    private final int ID;
    private final ArrayList<CompetitiveMember> competitors = new ArrayList<>();
    private final UI UI = new UI();

    public Competition(Type type, String date, String location, Discipline discipline) {
        this.COMPETITION_TYPE = type;
        this.DATE = convertStringToDate(date);
        this.LOCATION = location;
        this.DISCIPLINE = discipline;
        this.ID = UI.getValidCompetitionID();

    }

    public Competition(int ID, Type type, String date, String location, Discipline discipline) {
        this.ID = ID;
        this.COMPETITION_TYPE = type;
        this.DATE = convertStringToDate(date);
        this.LOCATION = location;
        this.DISCIPLINE = discipline;
    }

    public Date convertStringToDate(String sDate) {
        try {
            return new SimpleDateFormat("dd/MM/y").parse(sDate);
        } catch (ParseException e) {
            return Calendar.getInstance().getTime();
        }
    }

    public Type getCOMPETITION_TYPE() {
        return COMPETITION_TYPE;
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

    public boolean inCompetition(int id) {
        for (CompetitiveMember c : competitors) {
            if (c.getID() == id) {
                return true;
            }
        }
        return false;
    }

    private String fileCompetitorID() {
        StringBuilder text = new StringBuilder();
        for (CompetitiveMember c : competitors) {
            text.append(c.getID());
            text.append("_");
        }
        return text.toString();
    }

    private String dateFormatted() {
        DateFormat df = new SimpleDateFormat("dd/MM/y");
        return df.format(DATE);
    }

    public Discipline getDISCIPLINE() {
        return DISCIPLINE;
    }

    public Date getDATE() {
        return DATE;
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

    @Override
    public String toFileFormat() {
        return  ID
                + "_" + COMPETITION_TYPE.toString()
                + "_" + dateFormatted()
                + "_" + LOCATION
                + "_" + DISCIPLINE
                + "_" + fileCompetitorID();
    }

    public String toString() {
        return dateFormatted() + " : " + LOCATION + " -> " + DISCIPLINE + ", ID# " + getID();
    }
}
