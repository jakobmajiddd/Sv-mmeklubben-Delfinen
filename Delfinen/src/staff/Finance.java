package staff;

import main.UI;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

// @author Silke
public class Finance {
  private int passiveSubscription = 500;
  private int juniorSubscription = 1000;
  private double seniorSubscription = 1600;
  private double over60DiscountPercentage = 0.25;
  private double yearlyRevenue;
  private int passiveRevenue;
  private int juniorRevenue;
  private double seniorRevenue;
  private double seniorDiscountRevenue;
  private double seniorDiscountedSubscription;

  private File RECEIPTFILE = new File("src/files/Receipt.txt");
  private final LocalDateTime saleTime = LocalDateTime.now();
  DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

  UI ui = new UI();


  public double over60Discount() {
    double discount = seniorSubscription * over60DiscountPercentage;
    seniorDiscountedSubscription = seniorSubscription - discount;
    System.out.println(seniorDiscountedSubscription);
    return seniorDiscountedSubscription;
  }


  public double expectedRevenue() {
    over60Discount();

    ArrayList<Member> members = Chairman.members;
    members.add(new PassiveMember("Jens", 29, "jenner@gmail.com"));
    members.add(new PassiveMember("Jakob", 21, "j@gmail.com"));


    for (Member m : members) {
      if (m instanceof PassiveMember) {
        passiveRevenue += passiveSubscription;
        System.out.println(passiveRevenue);
      } else if (m instanceof FitnessMember) {
        if (m.getAge() < 18) {
          juniorRevenue += juniorSubscription;
        } else if (m.getAge() < 60) {
          seniorDiscountRevenue += seniorDiscountedSubscription;
        } else {
          seniorRevenue += seniorSubscription;
        }

      } else if (m instanceof CompetitiveMember) {
        if (m.getAge() < 18) {
          juniorRevenue += juniorSubscription;
        } else if (m.getAge() < 60) {
          seniorDiscountRevenue += seniorDiscountedSubscription;
        } else {
          seniorRevenue += seniorSubscription;
        }
      }
    }
    yearlyRevenue = passiveRevenue + juniorRevenue + seniorRevenue + seniorDiscountRevenue;
    ui.display(yearlyRevenue);
    return yearlyRevenue;
  }

  public void yearlySplitRevenue() {
    expectedRevenue();
    ui.display("Yearly total revenue for passive members: " + passiveRevenue);
    ui.display("Yearly total revenue for junior members: " + juniorRevenue);
    ui.display("Yearly total revenue for senior members: " + seniorRevenue);
    ui.display("Yearly total revenue for senior discounted members: " + seniorDiscountRevenue);
  }

  public void sendReceiptPassive(String name, String email, String membershipType) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPTFILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a "
              + membershipType
              + "\nPrice: "
              + passiveSubscription
              + "\nTime of sale: "
              + saleTime.format(timeformat)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      ui.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  public void sendReceiptJunior(String name, String email, String membershipType) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPTFILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a "
              + membershipType
              + "\nPrice: "
              + juniorSubscription
              + "\nTime of sale: "
              + saleTime.format(timeformat)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      ui.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  public void sendReceiptDiscountedSenior(String name, String email, String membershipType) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPTFILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a "
              + membershipType
              + "\nPrice: "
              + seniorDiscountedSubscription
              + "\nTime of sale: "
              + saleTime.format(timeformat)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      ui.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  public void sendReceiptSenior(String name, String email, String membershipType) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPTFILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a "
              + membershipType
              + "\nPrice: "
              + seniorSubscription
              + "\nTime of sale: "
              + saleTime.format(timeformat)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      ui.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  public void updatePayment() {
    ArrayList<Member> members = Chairman.members;
    ui.display("Enter member ID: ");
    int id = ui.getValidInt("Invalid ID");
    if (new Chairman().inMembersList(id)) {
      for (Member m : members) {
        if (m.getID() == id) {
          memberSetDate(m);
          break;
        }
      }
    } else {
      ui.display("No matching ID");
    }
  }


  public void memberSetDate(Member member) {
    Calendar c = Calendar.getInstance();
    c.setTime(Calendar.getInstance().getTime());
    c.add(Calendar.DATE, 365);
    member.setNextPaymentDate(c.getTime());
  }

  public boolean memberHasPaid(Member member) {
    Date c = Calendar.getInstance().getTime();
    return !c.after(member.getNextPaymentDate());
  }
}





 /* public void arrears() { //skal tage ArrayListen som parameter
    for (int i = 0; i < controller.getMembers().size(); i++) {
      if (//lastPaymentDate == moreThanOneYearAgo) {
        //flyt til betalingsstoppet-ArrayListe?
        //+ send betalingspåmindelse ? fra fil?
      }
    }*/

