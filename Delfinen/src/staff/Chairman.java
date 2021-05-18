package staff;

import competition.Discipline;
import controllers.MenuController;
import UI.UI;
import files.FileHandler;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Martin
 */

public class Chairman {
  private FileHandler fileHandler = new FileHandler();
  private UI ui = new UI();
  public static ArrayList<Member> members = new ArrayList<>();
  Finance finance = new Finance();


  public void createFitnessMember() {
    ui.displayAppend("Name: ");
    String name = ui.getString();

    ui.displayAppend("Age: ");
    int age = ui.getValidInt("Invalid");

    ui.displayAppend("Email: ");
    String email = ui.getString();
    members.add(new FitnessMember(name, age, email));

    if (age <= 18) {
      finance.sendReceiptJunior(name, email);
    }
    if (age > 60) {
      finance.sendReceiptDiscountedSenior(name, email);
    } else {
      finance.sendReceiptSenior(name, email);
    }
    fileHandler.saveMembers();
  }

  public void createPassiveMember() {
    ui.displayAppend("Name: ");
    String name = ui.getString();

    ui.displayAppend("Age: ");
    int age = ui.getValidInt("Invalid");

    ui.displayAppend("Email: ");
    String email = ui.getString();
    members.add(new PassiveMember(name, age, email));
    finance.sendReceiptPassive(name, email);
    fileHandler.saveMembers();
  }

  public void createCompetitiveMember() {
    ui.displayAppend("Name: ");
    String name = ui.getString();

    ui.displayAppend("Age: ");
    int age = ui.getValidInt("Invalid");

    ui.displayAppend("Email: ");
    String email = ui.getString();

    ui.displayAppend("Discipline (crawl, backcrawl, butterfly, breaststroke): ");
    Discipline discipline = ui.getDiscipline();

    CompetitiveMember member = new CompetitiveMember(name, age, email, discipline);
    members.add(member);

    if (age <= 18) {
      MenuController.junior.addStudent(member);
      member.assignTeam(MenuController.junior);
      finance.sendReceiptJunior(name, email);
    } else {
      MenuController.senior.addStudent(member);
      member.assignTeam(MenuController.senior);
      finance.sendReceiptSenior(name, email);
    }
    fileHandler.saveMembers();
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


