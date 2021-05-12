package staff;

import member.CompetitiveMember;

import java.util.ArrayList;
import java.util.Comparator;

public class Coach {
    private final String NAME;
    private ArrayList<CompetitiveMember> students = new ArrayList<>();

    public Coach(String name) {
        this.NAME = name;
    }

    public void assignStudent(CompetitiveMember student) {
        students.add(student);
    }

    public ArrayList<CompetitiveMember> studentsSorted() {
        students.sort(Comparator.comparingDouble(CompetitiveMember::getBestTime));
        return students;
    }

}
