package staff;

import main.UI;

public class Coach {

  UI ui = new UI();

  public void coachMenuDisplay() {
    boolean isRunning;

    do {
      isRunning = true;

      ui.printFinanceMenu();

      switch (ui.getInputNumber()) {

        case 1:
          System.out.println("Add swim time to member");
          //TO DO metode
          break;
        case 2:
          System.out.println("Pull top 5 senior swimmers for competition");
          //TO DO
          //en metode der trækker de fem bedste senior svømmere fra de fire discipliner
          //evt et valg af hvilken discplin man vil se fra?
          break;
        case 3:
          System.out.println("Pull top 5 junior swimmers for competition");
          //TO DO
          //en metode der trækker de fem bedste junior svømmere fra de fire discipliner
          //evt et valg af hvilken discplin man vil se fra?
        case 4:
          System.out.println("Add competition");
          //TO DO
        case 9:
          System.out.println("Return to main menu");
          isRunning = false;
      }
    } while (isRunning);
  }


}
