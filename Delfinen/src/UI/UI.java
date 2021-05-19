package UI;

import competition.Competition;
import competition.Type;
import competition.Discipline;
import controllers.CompetitionController;
import member.Member;
import staff.Chairman;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Alexander
 */

public class UI {
    private final Scanner SCANNER = new Scanner(System.in);

    public void incorrectOption(){
        System.out.println("Not a valid number/command");
        System.out.println("Pleas try agein");
    }

    public int getInt(){
        return SCANNER.nextInt();
    }
    public String getString(){
        return SCANNER.nextLine();
    }

    public void displayAppend(String msg){
        System.out.print(msg);
    }

    public void display(String msg){
        System.out.println(msg);
    }

    public int getValidMemberID() {
        if (Chairman.members.size() > 0) {
            Chairman.members.sort(Comparator.comparingInt(Member::getID));
            return Chairman.members.get(Chairman.members.size() - 1).getID() + 1;
        } else {
            return 1;
        }
    }

    public int getValidCompetitionID() {
        if (CompetitionController.competitions.size() > 0) {
            CompetitionController.competitions.sort(Comparator.comparingInt(Competition::getID));
            return CompetitionController.competitions.get(CompetitionController.competitions.size() - 1).getID() + 1;
        } else {
            return 1;
        }
    }

    public Discipline getDiscipline() {
        ArrayList<String> validWords = new ArrayList<>();
        validWords.add("crawl");
        validWords.add("backcrawl");
        validWords.add("butterfly");
        validWords.add("breaststroke");

        String d = getString().toLowerCase();
        while (!validWords.contains(d)) {
            display("Not a valid discipline");
            d = getString().toLowerCase();
        }
        switch (d) {
            case "crawl" -> {
                return Discipline.CRAWL;
            }
            case "backcrawl" -> {
                return Discipline.BACKCRAWL;
            }
            case "butterfly" -> {
                return Discipline.BUTTERFLY;
            }
            case "breaststroke" -> {
                return Discipline.BREASTSTROKE;
            }
        }
        return null;
    }
    public Discipline getDiscipline(String input) {
        switch (input.toLowerCase()) {
            case "crawl" -> {
                return Discipline.CRAWL;
            }
            case "backcrawl" -> {
                return Discipline.BACKCRAWL;
            }
            case "butterfly" -> {
                return Discipline.BUTTERFLY;
            }
            case "breaststroke" -> {
                return Discipline.BREASTSTROKE;
            }
        }
        return null;
    }

    public Type getCompetitionType(String input) {
        switch (input) {
            case "junior" -> {
                return Type.JUNIOR;
            }
            case "senior" -> {
                return Type.SENIOR;
            }
        }
        return null;
    }

    public Type getCompetitionType() {
        String s = getString().toLowerCase();
        while (!s.equals("junior") && !s.equals("senior")) {
            display("Not a valid competition type");
            s = getString().toLowerCase();
        }
        switch (s) {
            case "junior" -> {
                return Type.JUNIOR;
            }
            case "senior" -> {
                return Type.SENIOR;
            }
        }
        return null;
    }

    public int getValidInt(String errorMsg) {
        Scanner in = new Scanner(System.in);

        boolean valid = false;
        int choice = 0;
        while (!valid) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                valid = true;
            } else {
                in.next();
                System.out.println(errorMsg);
            }
        }
        return choice;
    }

    public int validateChoice(int r1, int r2, int quit, String errorMsg) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        boolean inRange = false;

        while (!inRange) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                if (choice >= r1 && choice <= r2 || choice == quit) {
                    inRange = true;
                } else {
                    System.out.println(errorMsg);
                }
            } else {
                System.out.println(errorMsg);
                in.next();
            }
        }
        return choice;
    }
}
