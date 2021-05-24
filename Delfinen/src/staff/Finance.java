package staff;

import UI.UI;
import files.FileHandler;
import member.Member;
import member.PassiveMember;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Silke
 */

public class Finance {
  private final int PASSIVE_SUBSCRIPTION = 500;
  private final int JUNIOR_SUBSCRIPTION = 1000;
  private final double SENIOR_SUBSCRIPTION = 1600;
  private final double DISCOUNT_SUBSCRIPTION = 1600 * 0.75;

  private final FileHandler fileHandler = new FileHandler();
  private final File RECEIPT_FILE = new File("Delfinen/Receipt.txt");
  private final LocalDateTime SALE_TIME = LocalDateTime.now();
  private final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("dd/MM/y");
  private final UI UI = new UI();

  private double getType(Member member) {
    if (member instanceof PassiveMember) {
      return PASSIVE_SUBSCRIPTION;
    }
    if (member.getAGE() < 18) {
      return JUNIOR_SUBSCRIPTION;
    }
    if (member.getAGE() >= 60) {
      return DISCOUNT_SUBSCRIPTION;
    }
    if (member.getAGE() >= 18 && member.getAGE() < 60) {
      return SENIOR_SUBSCRIPTION;
    }
    return 0;
  }


  public double expectedRevenue() {
    UI.display("");
    double total = 0;
    for (Member m : Chairman.members) {
      total += getType(m);
    }
    return total;
  }


  protected void sendReceiptPassive(String name, String email) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPT_FILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a passive membership"
              + "\n"
              + "\nPrice: "
              + PASSIVE_SUBSCRIPTION
              + "kr \nTime of sale: "
              + SALE_TIME.format(TIME_FORMAT)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      UI.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  protected void sendReceiptJunior(String name, String email) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPT_FILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a junior membership"
              + "\n"
              + "\nPrice: "
              + JUNIOR_SUBSCRIPTION
              + "kr \nTime of sale: "
              + SALE_TIME.format(TIME_FORMAT)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      UI.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  protected void sendReceiptDiscountedSenior(String name, String email) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPT_FILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a discounted senior membership"
              + "\n"
              + "\nPrice: "
              + DISCOUNT_SUBSCRIPTION
              + "kr \nTime of sale: "
              + SALE_TIME.format(TIME_FORMAT)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      UI.incorrectOption(); //måske lave om til decideret error-message
    }
  }

  protected void sendReceiptSenior(String name, String email) {
    try {
      FileWriter fileWriter = new FileWriter(RECEIPT_FILE);

      fileWriter.write(
          "\n------------------------------------"
              + "Send to: "
              + email
              + "\nHello "
              + name
              + "\nFind in this email your receipt for a senior membership"
              + "\n"
              + "\nPrice: "
              + SENIOR_SUBSCRIPTION
              + "kr \nTime of sale: "
              + SALE_TIME.format(TIME_FORMAT)
              + "\n------------------------------------"
      );
      fileWriter.close();
    } catch (IOException e) {
      UI.incorrectOption(); //måske lave om til decideret error-message
    }
  }


  public void updatePayment() {
    if (Chairman.members.size() > 0) {
      new Chairman().viewMembers();
      UI.displayAppend("Enter member ID: ");
      int id = UI.getValidInt("Invalid ID");
      if (new Chairman().inMembersList(id)) {
        for (Member m : Chairman.members) {
          if (m.getID() == id) {
            memberSetDate(m);
            break;
          }
        }
      } else {
        UI.display("No matching ID");
      }
    } else {
      UI.display("No members in the members list");
    }
    fileHandler.saveMembers();
  }

  private void memberSetDate(Member member) {
    Calendar c = Calendar.getInstance();
    c.setTime(Calendar.getInstance().getTime());
    c.add(Calendar.DATE, 365);
    member.setNextPaymentDate(c.getTime());
  }

  private boolean memberHasPaid(Member member) {
    Date c = Calendar.getInstance().getTime();
    return !c.after(member.getNextPaymentDate());
  }

  public void unpaidMembers() {
    UI.display("");
    if (Chairman.members.size() > 0) {
      boolean hasPaid;
      UI.display("Unpaid members: ");
      for (Member m : Chairman.members) {
        hasPaid = !memberHasPaid(m);
        if (hasPaid) {
          UI.display(m.toString());
        }
      }
    } else {
      UI.display("No members in the members list");
    }
  }
}
