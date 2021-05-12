package staff;


import main.Controller;
import main.UI;

// @author Silke
public class Accountant {
  private int passiveSubscription = 500;
  private int juniorSubscription = 1000;
  private double seniorSubscription = 1600;
  private double over60DiscountPercentage = 0.25;


  public int getPassiveSubscription() {
    return passiveSubscription;
  }

  public int getJuniorSubscription() {
    return juniorSubscription;
  }

  public double getSeniorSubscription() {
    return seniorSubscription;
  }

  public double getOver60DiscountPercentage() {
    return over60DiscountPercentage;
  }

  UI ui = new UI();
  Finance finance = new Finance();

  public void accountantMenuDisplay() {
    boolean isRunning;

    do {
      isRunning = true;

      ui.printFinanceMenu();

      switch (ui.getInputNumber()) {

        case 1:
          System.out.println("Yearly expected total revenue");
          finance.expectedRevenue();
          break;
        case 2:
          System.out.println("Expected revenue for passive members");
          finance.yearlyPassiveRevenue();
          break;
        case 3:
          System.out.println("Expected revenue for junior members");
          finance.yearlyJuniorRevenue();
        case 4:
          System.out.println("Expected revenue for senior members");
          finance.yearlySeniorRevenue();
        case 5:
          System.out.println("Expected revenue for senior discounted members");
          finance.yearlySeniorDiscountRevenue();
        case 6:
          System.out.println("Show members in arrears");
          //TO DO
        case 9:
          System.out.println("Return to main menu");
          isRunning = false;
      }
    } while (isRunning);
  }
}
