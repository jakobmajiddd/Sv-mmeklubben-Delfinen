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

  Accountant accountant = new Accountant();
  Controller controller = new Controller();


  public double expectedRevenue() {


    ArrayList<Member> members = controller.getMembers();
    members.add(new PassiveMember("Jens", 29, "jenner@gmail.com", new Date()));
    for (Member m : members) {
      if (m instanceof PassiveMember) {
        passiveRevenue += accountant.getPassiveSubscription();
      } else if (m instanceof FitnessMember) {
        if (m.getAGE() < 18) {
          juniorRevenue += accountant.getJuniorSubscription();
        } else if (m.getAGE() < 60) {
          seniorDiscountRevenue += accountant.getOver60Subscription();
        } else {
          seniorRevenue += accountant.getSeniorSubscription();
        }

      } else if (m instanceof CompetitiveMember) {
        if (m.getAGE() < 18) {
          juniorRevenue += accountant.getJuniorSubscription();
        } else if (m.getAGE() < 60) {
          seniorDiscountRevenue += accountant.getOver60Subscription();
        } else {
          seniorRevenue += accountant.getSeniorSubscription();
        }
      }
    }
    yearlyRevenue = passiveRevenue + juniorRevenue + seniorRevenue + seniorDiscountRevenue;
    return yearlyRevenue;
  }
}
