package controllers;

import competition.Team;
import files.FileHandler;
import menu.*;
import UI.UI;
import staff.Chairman;
import staff.Coach;
import staff.Finance;

/**
 * @author Martin
 */

public class MenuController {
  private FileHandler fileHandler = new FileHandler();
  private UI ui = new UI();
  private Chairman chairman = new Chairman();
  private Finance finance = new Finance();
  private CompetitionController cc = new CompetitionController();
  public static Team junior = new Team(new Coach("Patrick"), "Junior");
  public static Team senior = new Team(new Coach("Tina"), "Senior");

  private Menu mainMenu = new MainMenu();
  private Menu adminMenu = new AdminMenu();
  private Menu financeMenu = new FinanceMenu();
  private Menu creationMenu = new CreationMenu();
  private Menu competitiveMenu = new CompetitiveMenu();
  private Menu teamMenu = new TeamMenu();
  private Menu competitionMenu = new CompetitionMenu();

  public void run() {
    fileHandler.loadMembers();
    fileHandler.loadCompetitions();
    mainMenu();
  }

  public void mainMenu() {
    ui.display("");
    mainMenu.printMenu();
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
    adminMenu.printMenu();
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
    financeMenu.printMenu();
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
    creationMenu.printMenu();
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
    competitiveMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> teamMenu(junior);
      case 2 -> teamMenu(senior);
      case 3 -> competitionMenu();
      case 9 -> mainMenu();
    }
    competitiveMenu();
  }

  public void teamMenu(Team team) {
    ui.display("");
    ui.display(team.getTeamName() + " - Coach: " + team.getCoach().getName());
    teamMenu.printMenu();
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

  public void competitionMenu() {
    ui.display("");
    competitionMenu.printMenu();
    int choice = UI.validateChoice(1, 5, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> cc.viewCompetitions();
      case 2 -> cc.viewCompetitors();
      case 3 -> cc.createCompetition();
      case 4 -> cc.removeCompetition();
      case 5 -> cc.evaluateCompetition();
      case 9 -> competitiveMenu();
    }
    competitionMenu();
  }
}
