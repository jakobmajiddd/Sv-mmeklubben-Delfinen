package main;

import competition.Team;
import staff.Chairman;
import staff.Coach;
import staff.Finance;

/**
 * @author Martin
 */

public class Controller {
  UI ui = new UI();
  private Chairman chairman = new Chairman();
  private Finance finance = new Finance();
  public static Team junior = new Team(new Coach("XD"), "Junior Team");
  public static Team senior = new Team(new Coach("A1"), "Senior Team");

  public void run() {
    new Page();
    mainMenu();
  }

  public void mainMenu() {
    ui.display("");
    Page.mainMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> administrativeMenu();
      case 2 -> financeMenu();
      case 3 -> competitiveMenu();
      case 9 -> System.exit(0);
    }
  }

  public void administrativeMenu() {
    ui.display("");
    Page.adminMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> memberCreationMenu();
      case 2 -> chairman.removeMember();
      case 3 -> chairman.viewMembers();
      case 9 -> mainMenu();
    }
    administrativeMenu();
  }

  public void financeMenu() {
    ui.display("");
    Page.financeMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> ui.display(finance.expectedRevenue() + "kr.");
      case 2 -> finance.updatePayment();
      case 3 -> finance.unpaidMembers();
      case 9 -> mainMenu();
    }
    financeMenu();
  }

  public void memberCreationMenu() {
    ui.display("");
    Page.memberCreationMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> chairman.createPassiveMember();
      case 2 -> chairman.createFitnessMember();
      case 3 -> chairman.createCompetitiveMember();
      case 9 -> administrativeMenu();
    }
  }

  public void competitiveMenu() {
    ui.display("");
    Page.competitiveMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> teamMenu(junior);
      case 2 -> teamMenu(senior);
      case 3 -> System.out.println(); // Competitions
      case 9 -> mainMenu();
    }
  }

  public void teamMenu(Team team) {
    ui.display("");
    ui.display(team.getTeamName() + " - Coach: " + team.getCoach().getName());
    Page.teamMenu.printMenu();
    int choice = UI.validateChoice(1, 4, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> team.viewStudents();
      case 2 -> team.topStudents(5);
      case 3 -> team.assignToCompetition();
      case 4 -> team.changeBestTime();
      case 9 -> competitiveMenu();
    }
    teamMenu(team);
  }
}
