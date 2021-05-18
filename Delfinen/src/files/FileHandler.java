package files;

import UI.UI;
import competition.Competition;
import competition.CompetitionType;
import competition.Discipline;
import controllers.CompetitionController;
import controllers.MenuController;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;
import staff.Chairman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
  UI ui = new UI();

  public void saveMembers() {
    try {
      PrintStream ps = new PrintStream(new FileOutputStream("members.txt", false));
      for (Member m : Chairman.members) {
        ps.print(m.toFileFormat());
        ps.print("\n");
      }
      ps.close();
    } catch (FileNotFoundException e) {
      ui.display("File not found");
    }
  }

  public void saveCompetitions() {
    try {
      PrintStream ps = new PrintStream(new FileOutputStream("competitions.txt", false));
      for (Competition c : CompetitionController.competitions) {
        ps.print(c.toFileFormat());
        ps.print("\n");
      }
      ps.close();
    } catch (FileNotFoundException e) {
      ui.display("File not found");
    }
  }

  public void loadCompetitions() {
    for (String s : fileToList("competitions.txt")) {
      String[] temp = s.split("_");
      int id = Integer.parseInt(temp[0]);
      CompetitionType type = ui.getCompetitionType(temp[1].toLowerCase());
      String date = temp[2];
      String location = temp[3];
      Discipline discipline = ui.getDiscipline(temp[4]);
      CompetitionController.competitions.add(new Competition(id, type, date, location, discipline));
    }
  }

  public void loadMembers() {
    for (String s : fileToList("members.txt")) {
      String[] temp = s.split("_");
      switch (temp[1]) {
        case "PM" -> {
          int id = Integer.parseInt(temp[0]);
          String name = temp[2];
          int age = Integer.parseInt(temp[3]);
          String mail = temp[4];
          String date = temp[5];
          Chairman.members.add(new PassiveMember(id, name, age, mail, date));
        }
        case "FM" -> {
          int id = Integer.parseInt(temp[0]);
          String name = temp[2];
          int age = Integer.parseInt(temp[3]);
          String mail = temp[4];
          String date = temp[5];
          Chairman.members.add(new FitnessMember(id, name, age, mail, date));
        }
        case "CM" -> {
          int id = Integer.parseInt(temp[0]);
          String name = temp[2];
          int age = Integer.parseInt(temp[3]);
          String mail = temp[4];
          String date = temp[5];
          Discipline discipline = ui.getDiscipline(temp[6]);
          double bestTime = Double.parseDouble(temp[7]);
          CompetitiveMember member = new CompetitiveMember(id, name, age, mail, date, discipline, bestTime);
          Chairman.members.add(member);

          if (age <= 18) {
            MenuController.junior.addStudent(member);
            member.assignTeam(MenuController.junior);
          } else {
            MenuController.senior.addStudent(member);
            member.assignTeam(MenuController.senior);
          }
        }
      }
    }
  }

  public ArrayList<String> fileToList(String fileName) {
    ArrayList<String> storage = new ArrayList<>();

    try {
      Scanner scanner = new Scanner(new File(fileName));
      while (scanner.hasNextLine()) {
        String text = scanner.nextLine();
        storage.add(text);
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      ui.display("File not found");
    }

    return storage;
  }

}
