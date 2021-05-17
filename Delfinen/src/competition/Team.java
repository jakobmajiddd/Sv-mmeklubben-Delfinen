package competition;

import main.UI;
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
        students.sort(Comparator.comparingDouble(CompetitiveMember::getID));
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
                        if (student.getDiscipline().equals(discipline)) {
                            ui.display(student.competitiveStats());
                            count++;
                            if (count == range) {
                                break;
                            }
                        }
                    }
                } else {
                    for (CompetitiveMember student : students) {
                        if (student.getDiscipline().equals(discipline)) {
                            ui.display(student.competitiveStats());
                            count++;
                            if (count == occurrenceOfDiscipline(discipline)) {
                                break;
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

    public void assignToCompetition() {
        if (students.size() > 0) {

        } else {
            ui.display("No students to assign");
        }

    }

    public String getTeamName() {
        return teamName;
    }

    public Coach getCoach() {
        return coach;
    }
}
