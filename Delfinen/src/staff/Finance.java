package staff;

import main.Controller;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;

import java.util.ArrayList;
import java.util.Date;

// @author Silke
public class Finance {

  private double yearlyRevenue;
  private int passiveRevenue;
  private int juniorRevenue;
  private double seniorRevenue;
  private double seniorDiscountRevenue;
  private double over60Subscription;

  Accountant accountant = new Accountant();
  Controller controller = new Controller();


  public double over60Discount() {
    double discount = accountant.getSeniorSubscription() * accountant.getOver60DiscountPercentage();
    over60Subscription = accountant.getSeniorSubscription() - discount;
    System.out.println(over60Subscription);
    return over60Subscription;
  }


  public double expectedRevenue() {
    over60Discount();

    ArrayList<Member> members = controller.getMembers();
    members.add(new PassiveMember("Jens", 29, "jenner@gmail.com", new Date()));
    members.add(new PassiveMember("Jakob", 21, "j@gmail.com", new Date()));


    for (Member m : members) {
      if (m instanceof PassiveMember) {
        passiveRevenue += accountant.getPassiveSubscription();
        System.out.println(passiveRevenue);
      } else if (m instanceof FitnessMember) {
        if (m.getAGE() < 18) {
          juniorRevenue += accountant.getJuniorSubscription();
        } else if (m.getAGE() < 60) {
          seniorDiscountRevenue += over60Subscription;
        } else {
          seniorRevenue += accountant.getSeniorSubscription();
        }

      } else if (m instanceof CompetitiveMember) {
        if (m.getAGE() < 18) {
          juniorRevenue += accountant.getJuniorSubscription();
        } else if (m.getAGE() < 60) {
          seniorDiscountRevenue += over60Subscription;
        } else {
          seniorRevenue += accountant.getSeniorSubscription();
        }
      }
    }
    yearlyRevenue = passiveRevenue + juniorRevenue + seniorRevenue + seniorDiscountRevenue;
    System.out.println(yearlyRevenue);
    return yearlyRevenue;
  }

  public void yearlyPassiveRevenue() {
    expectedRevenue();
    System.out.println(passiveRevenue);
  }

  public void yearlyJuniorRevenue() {
    expectedRevenue();
    System.out.println(juniorRevenue);
  }

  public void yearlySeniorRevenue() {
    expectedRevenue();
    System.out.println(seniorRevenue);
  }

  public void yearlySeniorDiscountRevenue() {
    expectedRevenue();
    System.out.println(seniorDiscountRevenue);
  }

 /* public void arrears() { //skal tage ArrayListen som parameter
    for (int i = 0; i < controller.getMembers().size(); i++) {
      if (//lastPaymentDate == moreThanOneYearAgo) {
        //flyt til betalingsstoppet-ArrayListe?
        //+ send betalingspåmindelse ? fra fil?
      }
    }*/
}
