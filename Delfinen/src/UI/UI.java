package UI;
// @author Alexander
import competition.CompetitionType;
import competition.Discipline;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    Scanner scan = new Scanner(System.in);

    public void incorrectOption(){
        System.out.println("Not a valid number/command");
        System.out.println("Pleas try agein");
    }

    public int getInt(){
        return scan.nextInt();
    }
    public String getString(){
        return scan.nextLine();
    }

    public String getMessage(String msg){
        return msg;
    }

    public void displayAppend(String msg){
        System.out.print(msg);
    }

    public void display(String msg){
        System.out.println(msg);
    }

    public void display(double msg) {
        System.out.println(msg);
    }

    public void display(int msg) {
        System.out.println(msg);
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

    public CompetitionType getCompetitionType(String input) {
        switch (input) {
            case "junior" -> {
                return CompetitionType.JUNIOR;
            }
            case "senior" -> {
                return CompetitionType.SENIOR;
            }
        }
        return null;
    }

    public CompetitionType getCompetitionType() {
        String s = getString().toLowerCase();
        while (!s.equals("junior") && !s.equals("senior")) {
            display("Not a valid competition type");
            s = getString().toLowerCase();
        }
        switch (s) {
            case "junior" -> {
                return CompetitionType.JUNIOR;
            }
            case "senior" -> {
                return CompetitionType.SENIOR;
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

    public static int validateChoice(int r1, int r2, int quit, String errorMsg) {
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
