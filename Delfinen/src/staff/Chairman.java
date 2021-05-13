package staff;

import competition.Discipline;
import main.UI;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;
import java.util.ArrayList;

public class Chairman {
  private UI ui = new UI();
  public static ArrayList<Member> members = new ArrayList<>();

  public void createFitnessMember() {
    ui.displayAppend("Name: ");
    String name = ui.getString();

    ui.displayAppend("Age: ");
    int age = ui.getValidInt("Invalid");

    ui.displayAppend("Email: ");
    String email = ui.getString();
    members.add(new FitnessMember(name, age, email));
  }

  public void createPassiveMember() {
    ui.displayAppend("Name: ");
    String name = ui.getString();

    ui.displayAppend("Age: ");
    int age = ui.getValidInt("Invalid");

    ui.displayAppend("Email: ");
    String email = ui.getString();
    members.add(new PassiveMember(name, age, email));
  }

  public void createCompetitiveMember() {
    ArrayList<String> validWords = new ArrayList<>();
    validWords.add("crawl");
    validWords.add("backcrawl");
    validWords.add("butterfly");
    validWords.add("breaststroke");

    ui.displayAppend("Name: ");
    String name = ui.getString();

    ui.displayAppend("Age: ");
    int age = ui.getValidInt("Invalid");

    ui.displayAppend("Email: ");
    String email = ui.getString();

    ui.displayAppend("Discipline: ");
    String d = ui.getString().toLowerCase();
    while (!validWords.contains(d)) {
      ui.display("Not a valid discipline");
      d = ui.getString().toLowerCase();
    }
    Discipline discipline = ui.getDiscipline(d);

    members.add(new CompetitiveMember(name, age, email, discipline));
  }

  public void viewMembers() {
    if (members.size() > 0) {
      for (Member m : members) {
        ui.display(m.toString());
      }
    } else {
      ui.display("There are currently 0 members.");
    }
  }

  public boolean inMembersList(int id) {
    for (Member m : members) {
      if (m.getID() == id) {
        return true;
      }
    }
    return false;
  }

  public void removeMember() {
    int id = ui.getValidInt("Invalid input - Try again");
    if (inMembersList(id)) {
      for (Member m : members) {
        if (m.getID() == id) {
          members.remove(m);
          break;
        }
      }
    } else {
      ui.display("No member with the ID #" + id + " was found.");
    }
  }

  public ArrayList<Member> getMembers() {
    return members;
  }
}


