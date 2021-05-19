package competition;

import UI.UI;
import controllers.CompetitionController;
import files.FileHandler;
import member.CompetitiveMember;
import staff.Coach;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Martin
 */

public class Team {
    private UI ui = new UI();
    private String teamName;
    private Coach coach;
    private ArrayList<CompetitiveMember> students = new ArrayList<>();
    private FileHandler fileHandler = new FileHandler();

    public Team(Coach coach, String teamName) {
        this.coach = coach;
        this.teamName = teamName;
    }

    public void addStudent(CompetitiveMember student) {
        students.add(student);
    }

    public void viewStudents() {
        ui.display("");
        if (students.size() > 0) {
            sortByID();
            for (CompetitiveMember c : students) {
                ui.display(c.competitiveStats());
            }
        } else {
            ui.display("There are no members on this team");
        }
    }

    public void sortByTime() {
        students.sort(Comparator.comparingDouble(CompetitiveMember::getBestTime));
    }

    public void sortByID() {
        students.sort(Comparator.comparingInt(CompetitiveMember::getID));
    }

    public int occurrenceOfDiscipline(Discipline discipline) {
        int count = 0;
        for (CompetitiveMember student : students) {
            if (student.getDiscipline().equals(discipline)) {
                count ++;
            }
        }
        return count;
    }

    public void topStudents(int range) {
        Discipline[] disciplines = {Discipline.CRAWL, Discipline.BUTTERFLY, Discipline.BACKCRAWL, Discipline.BREASTSTROKE};
        int count = 0;

        ui.display("");
        if (students.size() > 0) {
            sortByTime();
            for (Discipline discipline : disciplines) {
                ui.display(discipline.toString() + ":");
                if (occurrenceOfDiscipline(discipline) > range) {
                    for (CompetitiveMember student : students) {
                        if (student.getBestTime() > 0) {
                            if (student.getDiscipline().equals(discipline)) {
                                ui.display(student.competitiveStats());
                                count++;
                                if (count == range) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    for (CompetitiveMember student : students) {
                        if (student.getDiscipline().equals(discipline)) {
                            if (student.getBestTime() > 0) {
                                ui.display(student.competitiveStats());
                                count++;
                                if (count == occurrenceOfDiscipline(discipline)) {
                                    break;
                                }
                            }
                        }
                    }
                }
                ui.display("");
                count = 0;
            }
        } else {
            ui.display("There are no members on this team");
        }
    }

    public boolean inStudentsList(int id) {
        for (CompetitiveMember c : students) {
            if (c.getID() == id) {
                return true;
            }
        }
        return false;
    }

    public void changeBestTime() {
        viewStudents();
        ui.display("");
        ui.displayAppend("Student ID: ");
        int id = ui.getValidInt("Invalid input - Try again");
        if (inStudentsList(id)) {
            for (CompetitiveMember c : students) {
                if (c.getID() == id) {
                    c.setBestTime(ui.getValidInt("Invalid input"));
                    break;
                }
            }
        } else {
            ui.display("No student with the ID #" + id + " was found.");
        }
    }

    public boolean isValidCompetition(int id) {
        for (Competition c : CompetitionController.competitions) {
            if (c.getID() == id) {
                if (ui.getCompetitionType(teamName.toLowerCase()).equals(c.getType())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayValidCompetitions() {
        for (Competition c : CompetitionController.competitions) {
            if (ui.getCompetitionType(teamName.toLowerCase()).equals(c.getType())) {
                ui.display(c.toString());
            }
        }
    }

    public CompetitiveMember getStudentByID(int id) {
        for (CompetitiveMember m : students) {
            if (m.getID() == id) {
                return m;
            }
        }
        return null;
    }

    public void assignToCompetition() {
        ui.display("");
        if (students.size() > 0) {
            ui.displayAppend("Students:");
            viewStudents();
            ui.display("");
            ui.display("Competitions");
            displayValidCompetitions();
            ui.display("");

            ui.displayAppend("Student ID: ");
            int studentID = ui.getValidInt("Invalid");

            ui.displayAppend("Competition ID: ");
            int competitionID = ui.getValidInt("Invalid");

            if (isValidCompetition(competitionID)) {
                for (Competition c : CompetitionController.competitions) {
                    if (c.getID() == competitionID) {
                        if (c.getDiscipline().equals(getStudentByID(studentID).getDiscipline()))
                            if (!c.inCompetition(studentID)) {
                                c.addCompetitor(getStudentByID(studentID));
                                break;
                            } else {
                                ui.display("Already assigned to this competition");
                        } else {
                            ui.display("Incompatible disciplines");
                        }
                    }
                }
            } else {
                ui.display("Invalid");
            }
        } else {
            ui.display("No students to assign");
        }
        fileHandler.saveCompetitions();
    }

    public String getTeamName() {
        return teamName;
    }

    public Coach getCoach() {
        return coach;
    }
}
