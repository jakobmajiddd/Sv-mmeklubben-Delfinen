package controllers;

import competition.Team;
import competition.Type;
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
  public static Team junior = new Team(new Coach("Patrick"), Type.JUNIOR);
  public static Team senior = new Team(new Coach("Tina"), Type.SENIOR);

  private final FileHandler FILE_HANDLER = new FileHandler();
  private final UI UI = new UI();
  private final Chairman CHAIRMAN = new Chairman();
  private final Finance FINANCE = new Finance();
  private final CompetitionController CC = new CompetitionController();

  private final Menu MAIN_MENU = new MainMenu();
  private final Menu ADMIN_MENU = new AdminMenu();
  private final Menu FINANCE_MENU = new FinanceMenu();
  private final Menu CREATION_MENU = new CreationMenu();
  private final Menu COMPETITIVE_MENU = new CompetitiveMenu();
  private final Menu TEAM_MENU = new TeamMenu();
  private final Menu COMPETITION_MENU = new CompetitionMenu();

  public void run() {
    FILE_HANDLER.loadMembers();
    FILE_HANDLER.loadCompetitions();
    mainMenu();
  }

  private void mainMenu() {
    UI.display("");
    MAIN_MENU.printMenu();
    int choice = UI.validRange(1, 3, 9, "Invalid input. Try again:");

    switch (choice) {
      case 1 -> administrativeMenu();
      case 2 -> financeMenu();
      case 3 -> competitiveMenu();
      case 9 -> System.exit(0);
    }
  }

  private void administrativeMenu() {
    UI.display("");
    ADMIN_MENU.printMenu();
    int choice = UI.validRange(1, 3, 9, "Invalid input. Try again:");

    switch (choice) {
      case 1 -> memberCreationMenu();
      case 2 -> CHAIRMAN.removeMember();
      case 3 -> CHAIRMAN.viewMembers();
      case 9 -> mainMenu();
    }
    administrativeMenu();
  }

  private void financeMenu() {
    UI.display("");
    FINANCE_MENU.printMenu();
    int choice = UI.validRange(1, 3, 9, "Invalid input. Try again:");

    switch (choice) {
      case 1 -> UI.display(FINANCE.expectedRevenue() + "kr.");
      case 2 -> FINANCE.updatePayment();
      case 3 -> FINANCE.unpaidMembers();
      case 9 -> mainMenu();
    }
    financeMenu();
  }

  private void memberCreationMenu() {
    UI.display("");
    CREATION_MENU.printMenu();
    int choice = UI.validRange(1, 3, 9, "Invalid input. Try again:");

    switch (choice) {
      case 1 -> CHAIRMAN.createPassiveMember();
      case 2 -> CHAIRMAN.createFitnessMember();
      case 3 -> CHAIRMAN.createCompetitiveMember();
      case 9 -> administrativeMenu();
    }
  }

  private void competitiveMenu() {
    UI.display("");
    COMPETITIVE_MENU.printMenu();
    int choice = UI.validRange(1, 3, 9, "Invalid input. Try again:");

    switch (choice) {
      case 1 -> teamMenu(junior);
      case 2 -> teamMenu(senior);
      case 3 -> competitionMenu();
      case 9 -> mainMenu();
    }
    competitiveMenu();
  }

  private void teamMenu(Team team) {
    UI.display("");
    UI.display(team.getTEAM_TYPE() + " - Coach: " + team.getCOACH().getNAME());
    TEAM_MENU.printMenu();
    int choice = UI.validRange(1, 4, 9, "Invalid input. Try again:");

    switch (choice) {
      case 1 -> team.viewStudents();
      case 2 -> team.topStudents(5);
      case 3 -> team.assignToCompetition();
      case 4 -> team.changeBestTime();
      case 9 -> competitiveMenu();
    }
    teamMenu(team);
  }

  private void competitionMenu() {
    UI.display("");
    COMPETITION_MENU.printMenu();
    int choice = UI.validRange(1, 5, 9, "Invalid input. Try again:");

    switch (choice) {
      case 1 -> CC.viewCompetitions();
      case 2 -> CC.viewCompetitors();
      case 3 -> CC.createCompetition();
      case 4 -> CC.removeCompetition();
      case 5 -> CC.evaluateCompetition();
      case 9 -> competitiveMenu();
    }
    competitionMenu();
  }
}
