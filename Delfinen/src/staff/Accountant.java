package staff;


import main.Controller;

// @author Silke
public class Accountant {
  private int passiveSubscription = 500;
  private int juniorSubscription = 1000;
  private double seniorSubscription = 1600;
  private double over60DiscountPercentage = 0.25;
  private double over60Subscription;


  public int getPassiveSubscription() {
    return passiveSubscription;
  }

  public int getJuniorSubscription() {
    return juniorSubscription;
  }

  public double getSeniorSubscription() {
    return seniorSubscription;
  }

  public double getOver60Subscription() {
    return over60Subscription;
  }


  Controller controller = new Controller();


  public double over60Discount() { //double seniorSubscription, double over60DiscountPercentage
    double discount = seniorSubscription * over60DiscountPercentage;
    over60Subscription = seniorSubscription - discount;
    System.out.println(over60Subscription); //test til at se om det regner rigtigt
    return over60Subscription;
  }

 /* public void arrears() { //skal tage ArrayListen som parameter
    for (int i = 0; i < controller.getMembers().size(); i++) {
      if (//lastPaymentDate == moreThanOneYearAgo) {
        //flyt til betalingsstoppet-ArrayListe?
        //+ send betalingspåmindelse ? fra fil?
      }
    }*/
  }
