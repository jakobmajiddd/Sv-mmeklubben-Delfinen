package staff;

import main.Controller;
import main.UI;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

  Controller controller = new Controller();
  UI ui = new UI();


  public double over60Discount() {
    double discount = seniorSubscription * over60DiscountPercentage;
    seniorDiscountedSubscription = seniorSubscription - discount;
    System.out.println(seniorDiscountedSubscription);
    return seniorDiscountedSubscription;
  }


  public double expectedRevenue() {
    over60Discount();

    ArrayList<Member> members = null; // controller.getMembers();
    members.add(new PassiveMember("Jens", 29, "jenner@gmail.com"));
    members.add(new PassiveMember("Jakob", 21, "j@gmail.com"));


    for (Member m : members) {
      if (m instanceof PassiveMember) {
        passiveRevenue += passiveSubscription;
        System.out.println(passiveRevenue);
      } else if (m instanceof FitnessMember) {
        if (m.getAGE() < 18) {
          juniorRevenue += juniorSubscription;
        } else if (m.getAGE() < 60) {
          seniorDiscountRevenue += seniorDiscountedSubscription;
        } else {
          seniorRevenue += seniorSubscription;
        }

      } else if (m instanceof CompetitiveMember) {
        if (m.getAGE() < 18) {
          juniorRevenue += juniorSubscription;
        } else if (m.getAGE() < 60) {
          seniorDiscountRevenue += seniorDiscountedSubscription;
        } else {
          seniorRevenue += seniorSubscription;
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
      ui.incoraktOption(); //måske lave om til decideret error-message
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
      ui.incoraktOption(); //måske lave om til decideret error-message
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
      ui.incoraktOption(); //måske lave om til decideret error-message
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
      ui.incoraktOption(); //måske lave om til decideret error-message
    }
  }
}





 /* public void arrears() { //skal tage ArrayListen som parameter
    for (int i = 0; i < controller.getMembers().size(); i++) {
      if (//lastPaymentDate == moreThanOneYearAgo) {
        //flyt til betalingsstoppet-ArrayListe?
        //+ send betalingspåmindelse ? fra fil?
      }
    }*/

