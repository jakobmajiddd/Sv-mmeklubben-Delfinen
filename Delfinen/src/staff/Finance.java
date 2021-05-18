package staff;

import UI.UI;
import member.Member;
import member.PassiveMember;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
  private double seniorDiscountedSubscription = 1600 * 0.75;

  private File RECEIPTFILE = new File("Delfinen/Receipt.txt");
  private final LocalDateTime saleTime = LocalDateTime.now();
  DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

  UI ui = new UI();
  ArrayList<Member> members = Chairman.members;

  public double getType(Member member) {
    if (member instanceof PassiveMember) {
      return passiveSubscription;
    }
    if (member.getAge() < 18) {
      return juniorSubscription;
    }
    if (member.getAge() >= 60) {
      return seniorDiscountedSubscription;
    }
    if (member.getAge() >= 18 && member.getAge() < 60) {
      return seniorSubscription;
    }
    return 0;
  }


  public double expectedRevenue() {
    ui.display("");
    double total = 0;
    for (Member m : members) {
      total += getType(m);
    }
    return total;
  }


  public void sendReceiptPassive(String name, String email) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPTFILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a passive membership"
              + "\n"
              + "\nPrice: "
              + passiveSubscription
              + "kr \nTime of sale: "
              + saleTime.format(timeformat)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      ui.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  public void sendReceiptJunior(String name, String email) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPTFILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a junior membership"
              + "\n"
              + "\nPrice: "
              + juniorSubscription
              + "kr \nTime of sale: "
              + saleTime.format(timeformat)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      ui.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  public void sendReceiptDiscountedSenior(String name, String email) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPTFILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a discounted senior membership"
              + "\n"
              + "\nPrice: "
              + seniorDiscountedSubscription
              + "kr \nTime of sale: "
              + saleTime.format(timeformat)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      ui.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  public void sendReceiptSenior(String name, String email) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPTFILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a senior membership"
              + "\n"
              + "\nPrice: "
              + seniorSubscription
              + "kr \nTime of sale: "
              + saleTime.format(timeformat)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      ui.incorrectOption(); //måske lave om til decideret error-message
    }
  }


  public void updatePayment() {
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

  public void unpaidMembers() {
    ui.display("");
    boolean hasPaid = false;
    ui.display("Unpaid members: ");
    for (Member m : members) {
      hasPaid = !memberHasPaid(m);
      if (hasPaid) {
        ui.display(m.toString());
      }
    }
    if (!hasPaid) {
      ui.display("None");
    }
  }
}

