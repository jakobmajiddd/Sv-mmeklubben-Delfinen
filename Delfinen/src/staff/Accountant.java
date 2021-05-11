package staff;


import main.Controller;

// @author Silke
public class Accountant {
  int passiveSubscription = 500;
  int juniorSubscription = 1000;
  double seniorSubscription = 1600;
  double over60DiscountPercentage = 0.25;
  double over60Subscription;

  //Member member = new Member();

  Controller controller = new Controller();


  public double over60Discount(double seniorSubscription, double over60DiscountPercentage) {
    double discount = seniorSubscription * over60DiscountPercentage;
    over60Subscription = seniorSubscription - discount;
    System.out.println(over60Subscription); //test til at se om det regner rigtigt
    return over60Subscription;
  }

  public void arrears() { //skal tage ArrayListen som parameter
    for (int i = 0; i < members.size(); i++) {
      if (lastPaymentDate == moreThanOneYearAgo) {
        //flyt til betalingsstoppet-ArrayListe?
        //+ send betalingspåmindelse ? fra fil?
      }

    }

  }



  //memberArrayList - træk fra main.Controller-klasse
  //ArrayList<main.Controller> members = new ArrayList<main.Controller>();

  public void expectedRevenue() { //int?

    for (int i = 0; i < passivemembers.size(); i++) {
      int totalRevenue =

    }

  }


}
