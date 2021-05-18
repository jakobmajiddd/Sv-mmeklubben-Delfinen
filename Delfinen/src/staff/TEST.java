package staff;

import UI.UI;
import files.FileHandler;
import member.Member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class TEST {
  static UI  ui = new UI();
  static FileHandler fileHandler = new FileHandler();

  public static void saveMembers() {
    try {
      PrintStream ps = new PrintStream(new FileOutputStream("members.txt", true));
      for (Member m : Chairman.members) {
        ps.append(m.toFileFormat());
        ps.append("\n");
      }
      ps.close();
    } catch (FileNotFoundException e) {
      //ui.display("File not found");
    }

  }

  public static void main(String[] args) {
    fileHandler.loadMembers();
    System.out.println(Chairman.members);
    ArrayList<Member> members = new ArrayList<>();
    Chairman chairman = new Chairman();

    chairman.createFitnessMember();
    chairman.createCompetitiveMember();
    chairman.createPassiveMember();
    fileHandler.saveMembers();
  }
}



