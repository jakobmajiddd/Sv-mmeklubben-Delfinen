package competition;

import main.UI;
import member.CompetitiveMember;
import member.Member;
import staff.Coach;

import java.util.ArrayList;
import java.util.Comparator;

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

    public void topStudents(int range) {
        if (students.size() > 0) {
            sortByTime();
            if (students.size() >= range) {
                for (int i = 0; i < range; i++) {
                    ui.display(students.get(i).competitiveStats());
                }
            } else {
                for (CompetitiveMember student : students) {
                    ui.display(student.competitiveStats());
                }
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
        ui.displayAppend("New best time: ");
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
