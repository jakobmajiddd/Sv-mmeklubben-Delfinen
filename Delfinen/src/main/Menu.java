package main;

import staff.Accountant;
import staff.Chairman;

public class Menu {

  UI ui = new UI();
  Chairman chairman = new Chairman();
  Accountant accountant = new Accountant();
  boolean keepRunning;

  // Alexander + Jakob
  public void mainMenu() {
    do {
      keepRunning = true;
      ui.printMainMenu();

      switch (ui.getInputNumber()) {
        case 1:
          chairmanMenuDisplay();
          break;
        case 2:
          accountant.accountantMenuDisplay();
          break;
        case 3:
          System.out.println("Coach");
          break;
        case 9:
          keepRunning = false;

      }


    } while (keepRunning);


  }


  // Alexander + Jakob
  public void chairmanMenuDisplay() {

    do {
      keepRunning = true;
      ui.printAdminMenu();

      switch (ui.getInputNumber()) {
        case 1:
          chairman.createMember();
          break;
        case 2:
          chairman.deleteMember();
          break;
        case 3:
          chairman.printMemberList();
          break;
        case 9:
          System.out.println("Go back\n");
          keepRunning = false;

      }

    } while (keepRunning);

  }


}
