package controllers;

import UI.UI;
import competition.Competition;
import competition.CompetitionType;
import competition.Discipline;
import files.FileHandler;
import member.CompetitiveMember;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CompetitionController {
    public static ArrayList<Competition> competitions = new ArrayList<>();
    private UI ui = new UI();
    private FileHandler fileHandler = new FileHandler();

    public void viewCompetitions() {
        if (competitions.size() > 0) {
            ui.display("");
            ui.display("Junior competitions: ");
            for (Competition c : competitions) {
                if (c.getType().equals(CompetitionType.JUNIOR)) {
                    ui.display(c.toString());
                }
            }
            ui.display("");
            ui.display("Senior competitions: ");
            for (Competition c : competitions) {
                if (c.getType().equals(CompetitionType.SENIOR)) {
                    ui.display(c.toString());
                }
            }
        } else {
            ui.display("");
            ui.display("No competitions found");
        }
    }

    public void viewCompetitors() {
        ui.display("");
        viewCompetitions();
        ui.display("");
        ui.displayAppend("Competition ID: ");
        int id = ui.getValidInt("Not a valid number");
        for (Competition c : competitions) {
            if (c.getID() == id) {
                if (c.getCompetitors().size() > 0) {
                    ui.display("");
                    for (CompetitiveMember m : c.getCompetitors()) {
                        ui.display(m.competitiveStats());
                    }
                } else {
                    ui.display("No competitors assigned to this competition");
                }
            }
        }
    }

    /**
     * @author Jacob
     */

    public void createCompetition() {
        ui.displayAppend("Junior / Senior: ");
        CompetitionType type = ui.getCompetitionType();

        ui.displayAppend("Date (d/MM/y): ");
        String date = ui.getString();
        while (!isValidDate(date)) {
            date = ui.getString();
        }

        ui.displayAppend("Location: ");
        String location = ui.getString();
        ui.displayAppend("Discipline (crawl, backcrawl, butterfly, breaststroke): ");
        Discipline discipline = ui.getDiscipline();
        competitions.add(new Competition(type,date, location, discipline));
        fileHandler.saveCompetitions();
    }

    public void removeCompetition() {
        if (competitions.size() > 0) {
            viewCompetitions();
            ui.display("");
            ui.displayAppend("Competition ID: ");
            int id = ui.getValidInt("Invalid");

            if (competitionExist(id)) {
                for (Competition c : competitions) {
                    if (c.getID() == id) {
                        competitions.remove(c);
                        break;
                    }
                }
            } else {
                ui.display("");
                ui.display("ID not found");
            }
        } else {
            ui.display("");
            ui.display("No competitions found");
        }
        fileHandler.saveCompetitions();
    }

    // Assigns competitors random placements, and removes the tournament.
    public void evaluateCompetition() {
        if (competitions.size() > 0) {
            viewCompetitions();
            ui.display("");
            ui.displayAppend("Competition ID: ");
            int id = ui.getValidInt("Invalid");

            if (competitionExist(id)) {
                for (Competition c : competitions) {
                    if (c.getID() == id) {
                        if (Calendar.getInstance().getTime().after(c.getDate())) {
                            c.assignPlacements();
                            competitions.remove(c);
                            break;
                        } else {
                            ui.display("Cannot evaluate a competition before the competition date");
                        }
                    }
                }
            } else {
                ui.display("");
                ui.display("ID not found");
            }
        } else {
            ui.display("");
            ui.display("No competitions found");
        }
        fileHandler.saveMembers();
        fileHandler.saveCompetitions();
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
        DateFormat formatter = new SimpleDateFormat("d/MM/y");
        formatter.setLenient(false);
        try {
            formatter.parse(d);
            return true;
        } catch (ParseException e) {
            ui.display("Invalid date format. Example: 04/04/2020");
            return false;
        }
    }
}
