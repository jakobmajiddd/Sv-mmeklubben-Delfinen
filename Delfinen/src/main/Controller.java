package main;

import staff.Chairman;
import staff.Finance;

// @author Martin
public class Controller {
  UI ui = new UI();
  private Chairman chairman = new Chairman();
  private Finance finance = new Finance();

  public void mainMenu() {
    String[] mainMenuItems = new String[4];
    mainMenuItems[0] = "1. Administrative";
    mainMenuItems[1] = "2. Finance";
    mainMenuItems[2] = "3. Competitions";
    mainMenuItems[3] = "9. Quit";
    Menu mainMenu = new Menu("Main menu", "Choose: ", mainMenuItems);

    ui.display("");
    mainMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> administrativeMenu();
      case 2 -> financeMenu();
      case 3 -> System.out.println("test3");
      case 9 -> {
        System.out.println("Quitting...");
        break;
      }
    }
    System.out.println("TEST!!");
  }

  public void administrativeMenu() {
    String[] adminMenuItems = new String[4];
    adminMenuItems[0] = "1. Add member";
    adminMenuItems[1] = "2. Remove member";
    adminMenuItems[2] = "3. Show members";
    adminMenuItems[3] = "9. Back";
    Menu adminMenu = new Menu("Admin menu", "Choose: ", adminMenuItems);

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
    String[] financeMenuItems = new String[4];
    financeMenuItems[0] = "1. View total yearly revenue";
    financeMenuItems[1] = "2. View subtotal revenue from every member type";
    financeMenuItems[2] = "3. View members with unpaid subscriptions";
    financeMenuItems[3] = "9. Back";
    Menu financeMenu = new Menu("Finance menu", "Choose: ", financeMenuItems);

    ui.display("");
    financeMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> finance.expectedRevenue();
      case 2 -> finance.yearlySplitRevenue();
      case 3 -> System.out.println();//finance.findUnpaidMembers();
      case 9 -> mainMenu();
    }
  }

  public void memberCreationMenu() {
    String[] memberCreationItems = new String[4];
    memberCreationItems[0] = "1. Passive member";
    memberCreationItems[1] = "2. Fitness member";
    memberCreationItems[2] = "3. Competitive member";
    memberCreationItems[3] = "9. Back";
    Menu memberCreationMenu = new Menu("Creation menu", "Choose: ", memberCreationItems);

    ui.display("");
    memberCreationMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> chairman.createPassiveMember();
      case 2 -> chairman.createFitnessMember();
      case 3 -> chairman.createCompetitiveMember();
      case 9 -> mainMenu();
    }
  }
}
