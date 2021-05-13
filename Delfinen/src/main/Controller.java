package main;

import staff.Chairman;

public class Controller {
  private Chairman chairman = new Chairman();

  public void mainMenu() {
    String[] mainMenuItems = new String[4];
    mainMenuItems[0] = "1. Administrative";
    mainMenuItems[1] = "2. Finance";
    mainMenuItems[2] = "3. Competitions";
    mainMenuItems[3] = "9. Quit";
    Menu mainMenu = new Menu("Main menu", "Choose: ", mainMenuItems);

    System.out.println();
    mainMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> administrativeMenu();
      case 2 -> financeMenu();
      case 3 -> System.out.println("test3");
      case 9 -> System.out.println("Quitting...");
    }
  }

  public void administrativeMenu() {
    String[] adminMenuItems = new String[4];
    adminMenuItems[0] = "1. Add member";
    adminMenuItems[1] = "2. Remove member";
    adminMenuItems[2] = "3. Show members";
    adminMenuItems[3] = "9. Back";
    Menu adminMenu = new Menu("Admin menu", "Choose: ", adminMenuItems);

    System.out.println();
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
    financeMenuItems[0] = "1. View yearly revenue";
    financeMenuItems[1] = "2. X";
    financeMenuItems[2] = "3. Y";
    financeMenuItems[3] = "9. Back";
    Menu financeMenu = new Menu("Finance menu", "Choose: ", financeMenuItems);

    System.out.println();
    financeMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> System.out.println("test1");
      case 2 -> System.out.println("test2");
      case 3 -> System.out.println("test3");
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

    System.out.println();
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
