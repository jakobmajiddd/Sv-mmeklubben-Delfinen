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

  UI ui = new UI();
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

  // Jakob
  public void createPassivMember() {
    String name = ui.getInputText();
    int age = ui.getInputNumber();
    String email = ui.getInputText();

    members.add(new PassiveMember(name, age, email));


  }

  // Jakob
  public void createFitnessMember() {
    String name = ui.getInputText();
    int age = ui.getInputNumber();
    String email = ui.getInputText();

    members.add(new FitnessMember(name, age, email));


  }

  // Jakob
  public void createCompetitiveMember() {
    String name = ui.getInputText();
    int age = ui.getInputNumber();
    String email = ui.getInputText();

    members.add(new CompetitiveMember(name, age, email, new Coach(), new Competition("", "", Discipline.BACKCRAWL), Discipline.BACKCRAWL));

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

