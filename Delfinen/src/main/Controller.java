package main;

import staff.Chairman;
import staff.Finance;

// @author Martin
public class Controller {
  UI ui = new UI();
  private Chairman chairman = new Chairman();
  private Finance finance = new Finance();

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
      case 3 -> System.out.println("test3");
      case 9 -> ui.display("Quitting...");
    }
    System.out.println(Page.mainMenu);
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
      case 1 -> finance.expectedRevenue();
      case 2 -> finance.yearlySplitRevenue();
      case 3 -> System.out.println();//finance.findUnpaidMembers();
      case 9 -> mainMenu();
    }
  }

  public void memberCreationMenu() {
    ui.display("");
    Page.memberCreationMenu.printMenu();
    int choice = UI.validateChoice(1, 3, 9, "Invalid input - Try again");

    switch (choice) {
      case 1 -> chairman.createPassiveMember();
      case 2 -> chairman.createFitnessMember();
      case 3 -> chairman.createCompetitiveMember();
      case 9 -> mainMenu();
    }
  }
}
