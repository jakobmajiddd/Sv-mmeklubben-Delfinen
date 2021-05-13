package staff;

import main.UI;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;

import java.util.ArrayList;


//public class Chairman {
  //String membershipType;
//
  //UI ui = new UI();
  //Finance finance = new Finance();
  //ArrayList<Member> members = new ArrayList<>();
//
//
  //// Jakob
  //public void createMember() {
  //  ui.printCreatMemberMenu();
  //  boolean keepRun = true;
  //  do {
//
  //    switch (ui.getInputNumber()) {
  //      case 1 -> createPassiveMember();
  //      case 2 -> createFitnessMember();
  //      case 3 -> createCompetitiveMember();
  //      case 9 -> keepRun = false;
  //    }
//
  //  } while (keepRun);
//
//
  //}
//
  //// Jakob & Silke
  //public void createPassiveMember() {
  //  String name = ui.getInputText();
  //  int age = ui.getInputNumber();
  //  String email = ui.getInputText();
  //  this.membershipType = "passive membership"; //enum?
//
  //  members.add(new PassiveMember(name, age, email));
//
  //  finance.sendReceiptPassive(name, email, membershipType);
//
//
  //}
//
  //// Jakob & Silke
  //public void createFitnessMember() {
  //  String name = ui.getInputText();
  //  int age = ui.getInputNumber();
  //  String email = ui.getInputText();
//
  //  members.add(new FitnessMember(name, age, email));
//
  //  if (age < 18) {
  //    String membershipType = "junior membership";
  //    finance.sendReceiptJunior(name, email, membershipType);
  //  } if (age < 60) {
  //    String membershipType = "discounted senior membership";
  //    finance.sendReceiptDiscountedSenior(name, email, membershipType);
  //  } else {
  //    String membershipType = "senior";
  //    finance.sendReceiptSenior(name, email, membershipType);
  //  }
//
//
  //}
//
  //// Jakob & Silke
  //public void createCompetitiveMember() {
  //  String name = ui.getInputText();
  //  int age = ui.getInputNumber();
  //  String email = ui.getInputText();
//
  //  //members.add(new CompetitiveMember(name, age, email, new Coach(), new Competition("", "", Discipline.BACKCRAWL), Discipline.BACKCRAWL));
//
  //  if (age < 18) {
  //    String membershipType = "junior membership";
  //    finance.sendReceiptJunior(name, email, membershipType);
  //  } if (age < 60) {
  //    String membershipType = "discounted senior membership";
  //    finance.sendReceiptDiscountedSenior(name, email, membershipType);
  //  } else {
  //    String membershipType = "senior";
  //    finance.sendReceiptSenior(name, email, membershipType);
  //  }
//
  //}


public class Chairman {
  UI ui = new UI();
  ArrayList<Member> members = new ArrayList<>();

  public void createFitnessMember() {
    ui.displayAppend("Name: ");
    String name = ui.getString();

    ui.displayAppend("Age: ");
    int age = ui.getValidInt("Invalid");

    ui.displayAppend("Email: ");
    String email = ui.getString();
    members.add(new FitnessMember(name, age, email));
  }

  public PassiveMember createPassiveMember() {
    return null;
  }

  public CompetitiveMember createCompetitiveMember() {
    return null;
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
}


