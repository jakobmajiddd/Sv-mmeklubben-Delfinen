package staff;

import competition.Competition;
import competition.Discipline;
import main.UI;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;

import java.util.ArrayList;


public class Chairman {
  String membershipType;

  UI ui = new UI();
  Finance finance = new Finance();
  ArrayList<Member> members = new ArrayList<>();


  // Jakob
  public void createMember() {
    ui.printCreatMemberMenu();
    boolean keepRun = true;
    do {

      switch (ui.getInputNumber()) {
        case 1:
          createPassivMember();
          break;
        case 2:
          createFitnessMember();
          break;
        case 3:
          createCompetitiveMember();
          break;
        case 9:
          keepRun = false;
      }

    } while (keepRun);


  }

  // Jakob & Silke
  public void createPassivMember() {
    String name = ui.getInputText();
    int age = ui.getInputNumber();
    String email = ui.getInputText();
    this.membershipType = "passive membership"; //enum?

    members.add(new PassiveMember(name, age, email));

    finance.sendReceiptPassive(name, email, membershipType);


  }

  // Jakob & Silke
  public void createFitnessMember() {
    String name = ui.getInputText();
    int age = ui.getInputNumber();
    String email = ui.getInputText();

    members.add(new FitnessMember(name, age, email));

    if (age < 18) {
      String membershipType = "junior membership";
      finance.sendReceiptJunior(name, email, membershipType);
    } if (age < 60) {
      String membershipType = "discounted senior membership";
      finance.sendReceiptDiscountedSenior(name, email, membershipType);
    } else {
      String membershipType = "senior";
      finance.sendReceiptSenior(name, email, membershipType);
    }


  }

  // Jakob & Silke
  public void createCompetitiveMember() {
    String name = ui.getInputText();
    int age = ui.getInputNumber();
    String email = ui.getInputText();

    //members.add(new CompetitiveMember(name, age, email, new Coach(), new Competition("", "", Discipline.BACKCRAWL), Discipline.BACKCRAWL));

    if (age < 18) {
      String membershipType = "junior membership";
      finance.sendReceiptJunior(name, email, membershipType);
    } if (age < 60) {
      String membershipType = "discounted senior membership";
      finance.sendReceiptDiscountedSenior(name, email, membershipType);
    } else {
      String membershipType = "senior";
      finance.sendReceiptSenior(name, email, membershipType);
    }

  }

  // Jakob
  public void deleteMember() {

    members.remove(ui.getInputNumber());

  }

  public void printMemberList() {
    for (int i = 0; i <= members.size(); i++) {
      System.out.println(members.get(i));
    }


  }
}

