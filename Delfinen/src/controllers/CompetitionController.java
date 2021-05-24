package controllers;

import UI.UI;
import competition.Competition;
import competition.Type;
import competition.Discipline;
import files.FileHandler;
import member.CompetitiveMember;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Martin
 */

public class CompetitionController {
    public static ArrayList<Competition> competitions = new ArrayList<>();
    private final UI UI = new UI();
    private final FileHandler FILE_HANDLER = new FileHandler();

    void viewCompetitions() {
        if (competitions.size() > 0) {
            UI.display("");
            UI.display("Junior competitions: ");
            for (Competition c : competitions) {
                if (c.getCOMPETITION_TYPE().equals(Type.JUNIOR)) {
                    UI.display(c.toString());
                }
            }
            UI.display("");
            UI.display("Senior competitions: ");
            for (Competition c : competitions) {
                if (c.getCOMPETITION_TYPE().equals(Type.SENIOR)) {
                    UI.display(c.toString());
                }
            }
        } else {
            UI.display("");
            UI.display("No competitions found");
        }
    }

    void viewCompetitors() {
        if (competitions.size() > 0) {
            viewCompetitions();
            UI.display("");
            UI.displayAppend("Competition ID: ");
            int id = UI.getValidInt("Not a valid number");
            for (Competition c : competitions) {
                if (c.getID() == id) {
                    if (c.getCompetitors().size() > 0) {
                        UI.display("");
                        for (CompetitiveMember m : c.getCompetitors()) {
                            UI.display(m.competitiveStats());
                        }
                    } else {
                        UI.display("No competitors assigned to this competition");
                    }
                }
            }
        } else {
            UI.display("");
            UI.display("No competitions found");
        }
    }

    /**
     * @author Jacob
     */

    void createCompetition() {
        UI.displayAppend("Junior / Senior: ");
        Type type = UI.getCompetitionType();

        UI.displayAppend("Date (dd/MM/y): ");
        String date = UI.getString();
        while (!isValidDate(date)) {
            date = UI.getString();
        }

        UI.displayAppend("Location: ");
        String location = UI.getString();
        UI.displayAppend("Discipline (crawl, backcrawl, butterfly, breaststroke): ");
        Discipline discipline = UI.getDiscipline();
        competitions.add(new Competition(type,date, location, discipline));
        FILE_HANDLER.saveCompetitions();
    }

    /**
     * @author Martin
     */

    void removeCompetition() {
        if (competitions.size() > 0) {
            viewCompetitions();
            UI.display("");
            UI.displayAppend("Competition ID: ");
            int id = UI.getValidInt("Invalid");

            if (competitionExist(id)) {
                for (Competition c : competitions) {
                    if (c.getID() == id) {
                        competitions.remove(c);
                        break;
                    }
                }
            } else {
                UI.display("");
                UI.display("ID not found");
            }
        } else {
            UI.display("");
            UI.display("No competitions found");
        }
        FILE_HANDLER.saveCompetitions();
    }

    // Assigns competitors random placements, and removes the tournament.
    void evaluateCompetition() {
        if (competitions.size() > 0) {
            viewCompetitions();
            UI.display("");
            UI.displayAppend("Competition ID: ");
            int id = UI.getValidInt("Invalid");

            if (competitionExist(id)) {
                for (Competition c : competitions) {
                    if (c.getID() == id) {
                        if (Calendar.getInstance().getTime().after(c.getDATE())) {
                            c.assignPlacements();
                            competitions.remove(c);
                            break;
                        } else {
                            UI.display("Cannot evaluate a competition before the competition date");
                        }
                    }
                }
            } else {
                UI.display("");
                UI.display("ID not found");
            }
        } else {
            UI.display("");
            UI.display("No competitions found");
        }
        FILE_HANDLER.saveMembers();
        FILE_HANDLER.saveCompetitions();
    }

    boolean competitionExist(int id) {
        for (Competition c : competitions) {
            if (c.getID() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidDate(String d) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/y");
        formatter.setLenient(false);
        try {
            formatter.parse(d);
            return true;
        } catch (ParseException e) {
            UI.display("Invalid date format. Example: 04/04/2020");
            return false;
        }
    }
}
