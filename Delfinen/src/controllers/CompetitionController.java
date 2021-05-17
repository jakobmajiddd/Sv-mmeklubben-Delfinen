package controllers;

import UI.UI;
import competition.Competition;
import competition.CompetitionType;
import competition.Discipline;
import java.util.ArrayList;

public class CompetitionController {
    public static ArrayList<Competition> competitions = new ArrayList<>();
    private UI ui = new UI();

    public void viewCompetitions() {
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
    }

    /**
     * @author Jacob
     */
    public void createCompetition() {
        ui.displayAppend("Junior / Senior: ");
        CompetitionType type = ui.getCompetitionType();
        ui.displayAppend("Date (d/MM/y): ");
        String date = ui.getString();
        ui.displayAppend("Location: ");
        String location = ui.getString();
        ui.displayAppend("Discipline (crawl, backcrawl, butterfly, breaststroke): ");
        Discipline discipline = ui.getDiscipline();
        competitions.add(new Competition(type,date, location, discipline));
    }

    public void removeCompetition() {
        ui.display("ID: ");
        int id = ui.getValidInt("Invalid");

        if (competitionExist(id)) {
            for (Competition c : competitions) {
                if (c.getID() == id) {
                    competitions.remove(c);
                    break;
                }
            }
        } else {
            ui.display("ID not found");
        }
    }

    boolean competitionExist(int id) {
        for (Competition c : competitions) {
            if (c.getID() == id) {
                return true;
            }
        }
        return false;
    }
}
