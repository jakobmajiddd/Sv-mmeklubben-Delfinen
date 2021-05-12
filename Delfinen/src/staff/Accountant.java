package staff;


import main.Controller;
import main.UI;

// @author Silke
public class Accountant {

  UI ui = new UI();
  Finance finance = new Finance();

  public void accountantMenuDisplay() {
    boolean isRunning;

    do {
      isRunning = true;

      ui.printFinanceMenu();

      switch (ui.getInputNumber()) {

        case 1:
          finance.expectedRevenue();
          break;
        case 2:
          finance.yearlyPassiveRevenue();
          break;
        case 3:
          finance.yearlyJuniorRevenue();
        case 4:
          finance.yearlySeniorRevenue();
        case 5:
          finance.yearlySeniorDiscountRevenue();
        case 6:
          System.out.println("Show members in arrears");
          //TO DO
        case 9:
          isRunning = false;
      }
    } while (isRunning);
  }
}
