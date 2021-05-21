package staff;

import competition.Discipline;
import controllers.MenuController;
import UI.UI;
import files.FileHandler;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;
import java.util.ArrayList;

/**
 * @author Martin
 */

public class Chairman {
  private final FileHandler FILE_HANDLER = new FileHandler();
  private final UI UI = new UI();
  private final Finance FINANCE = new Finance();
  public static ArrayList<Member> members = new ArrayList<>();

  public void createFitnessMember() {
    UI.display("");
    UI.displayAppend("Name: ");
    String name = UI.getString();

    UI.displayAppend("Age: ");
    int age = UI.getValidInt("Invalid");

    UI.displayAppend("Email: ");
    String email = UI.getString();
    members.add(new FitnessMember(name, age, email));

    if (age <= 18) {
      FINANCE.sendReceiptJunior(name, email);
    }
    if (age > 60) {
      FINANCE.sendReceiptDiscountedSenior(name, email);
    } else {
      FINANCE.sendReceiptSenior(name, email);
    }
    System.out.println("HERE");
    FILE_HANDLER.saveMembers();
  }

  public void createPassiveMember() {
    UI.display("");
    UI.displayAppend("Name: ");
    String name = UI.getString();

    UI.displayAppend("Age: ");
    int age = UI.getValidInt("Invalid");

    UI.displayAppend("Email: ");
    String email = UI.getString();

    members.add(new PassiveMember(name, age, email));
    FINANCE.sendReceiptPassive(name, email);
    FILE_HANDLER.saveMembers();
  }

  public void createCompetitiveMember() {
    UI.display("");
    UI.displayAppend("Name: ");
    String name = UI.getString();

    UI.displayAppend("Age: ");
    int age = UI.getValidInt("Invalid");

    UI.displayAppend("Email: ");
    String email = UI.getString();

    UI.displayAppend("Discipline (crawl, backcrawl, butterfly, breaststroke): ");
    Discipline discipline = UI.getDiscipline();

    CompetitiveMember member = new CompetitiveMember(name, age, email, discipline);
    members.add(member);

    if (age <= 18) {
      MenuController.junior.addStudent(member);
      FINANCE.sendReceiptJunior(name, email);
    } else {
      MenuController.senior.addStudent(member);
      FINANCE.sendReceiptSenior(name, email);
    }
    FILE_HANDLER.saveMembers();
  }

  public void viewMembers() {
    UI.display("");
    if (members.size() > 0) {
      for (Member m : members) {
        UI.display(m.toString());
      }
    } else {
      UI.display("There are currently 0 members.");
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
    viewMembers();
    UI.display("");
    UI.displayAppend("Member ID: ");
    int id = UI.getValidInt("Invalid input - Try again");
    if (inMembersList(id)) {
      for (Member m : members) {
        if (m.getID() == id) {
          members.remove(m);
          break;
        }
      }
    } else {
      UI.display("No member with the ID #" + id + " was found.");
    }
    FILE_HANDLER.saveMembers();
  }
}
