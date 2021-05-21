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
    private final UI UI = new UI();
    private final Type TEAM_TYPE;
    private final Coach COACH;
    private ArrayList<CompetitiveMember> students = new ArrayList<>();
    private final FileHandler FILE_HANDLER = new FileHandler();

    public Team(Coach coach, Type type) {
        this.COACH = coach;
        this.TEAM_TYPE = type;
    }

    public void addStudent(CompetitiveMember student) {
        students.add(student);
    }

    public void viewStudents() {
        UI.display("");
        if (students.size() > 0) {
            sortByID();
            for (CompetitiveMember c : students) {
                UI.display(c.competitiveStats());
            }
        } else {
            UI.display("There are no members on this team");
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
            if (student.getDISCIPLINE().equals(discipline)) {
                count ++;
            }
        }
        return count;
    }

    public void topStudents(int range) {
        Discipline[] disciplines = {Discipline.CRAWL, Discipline.BUTTERFLY, Discipline.BACKCRAWL, Discipline.BREASTSTROKE};
        int count = 0;

        UI.display("");
        if (students.size() > 0) {
            sortByTime();
            for (Discipline discipline : disciplines) {
                UI.display(discipline.toString() + ":");
                if (occurrenceOfDiscipline(discipline) > range) {
                    for (CompetitiveMember student : students) {
                        if (student.getBestTime() > 0) {
                            if (student.getDISCIPLINE().equals(discipline)) {
                                UI.display(student.competitiveStats());
                                count++;
                                if (count == range) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    for (CompetitiveMember student : students) {
                        if (student.getDISCIPLINE().equals(discipline)) {
                            if (student.getBestTime() > 0) {
                                UI.display(student.competitiveStats());
                                count++;
                                if (count == occurrenceOfDiscipline(discipline)) {
                                    break;
                                }
                            }
                        }
                    }
                }
                UI.display("");
                count = 0;
            }
        } else {
            UI.display("There are no members on this team");
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
        if (students.size() > 0) {
            viewStudents();
            UI.displayAppend("Student ID: ");
            int id = UI.getValidInt("Invalid input - Try again");
            if (inStudentsList(id)) {
                for (CompetitiveMember c : students) {
                    if (c.getID() == id) {
                        UI.displayAppend("Set best time: ");
                        c.setBestTime(UI.getValidDouble("Invalid input"));
                        break;
                    }
                }
            } else {
                UI.display("No student with the ID #" + id + " was found.");
            }
        } else {
            UI.display("");
            UI.display("There are no members on this team");
        }
        FILE_HANDLER.saveMembers();
    }

    public boolean isValidCompetition(int id) {
        for (Competition c : CompetitionController.competitions) {
            if (c.getID() == id) {
                if (TEAM_TYPE.equals(c.getCOMPETITION_TYPE())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayValidCompetitions() {
        for (Competition c : CompetitionController.competitions) {
            if (TEAM_TYPE.equals(c.getCOMPETITION_TYPE())) {
                UI.display(c.toString());
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
        UI.display("");
        if (students.size() > 0) {
            UI.displayAppend("Students:");
            viewStudents();
            UI.display("");
            UI.display("Competitions");
            displayValidCompetitions();
            UI.display("");

            UI.displayAppend("Student ID: ");
            int studentID = UI.getValidInt("Invalid");

            if (inStudentsList(studentID)) {

                UI.displayAppend("Competition ID: ");
                int competitionID = UI.getValidInt("Invalid");

                if (isValidCompetition(competitionID)) {
                    for (Competition c : CompetitionController.competitions) {
                        if (c.getID() == competitionID) {
                            if (c.getDISCIPLINE().equals(getStudentByID(studentID).getDISCIPLINE()))
                                if (!c.inCompetition(studentID)) {
                                    c.addCompetitor(getStudentByID(studentID));
                                    break;
                                } else {
                                    UI.display("Already assigned to this competition");
                                }
                            else {
                                UI.display("Incompatible disciplines");
                            }
                        }
                    }
                } else {
                    UI.display("Invalid");
                }
            } else {
                UI.display("No students to assign");
            }
        }
        FILE_HANDLER.saveCompetitions();
    }

    public Type getTEAM_TYPE() {
        return TEAM_TYPE;
    }

    public Coach getCOACH() {
        return COACH;
    }
}
