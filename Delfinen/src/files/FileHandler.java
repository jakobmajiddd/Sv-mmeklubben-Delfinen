package files;

import UI.UI;
import competition.Competition;
import competition.CompetitionType;
import competition.Discipline;
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
      PrintStream ps = new PrintStream(new FileOutputStream("members.txt", true));
      for (Member m : Chairman.members) {
        ps.append(m.toFileFormat());
        ps.append("\n");
      }
      ps.close();
    } catch (FileNotFoundException e) {
      ui.display("File not found");
    }

  }

  public void loadMembers() {
    for (String s : reader("members.txt")) {
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
          Chairman.members.add(new CompetitiveMember(id, name, age, mail, date, discipline));
        }



      }

    }


  }

  public ArrayList<String> reader(String fileName) {
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
