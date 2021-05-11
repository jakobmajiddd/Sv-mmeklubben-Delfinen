package staff;

import member.Member;
import member.PassiveMember;

import java.util.ArrayList;
import java.util.Date;


public class Chairman {

  ArrayList<Member> members = new ArrayList<>();

  public void chairmanText(String text) {
    System.out.println(text);
  }

  public void menuDisplay() {
    chairmanText ("1. Add member\n" +
        "2. Remove member\n" +
        "3. Edit member data\n" +
        "4. Print list of members\n" +
        "5. Log out\n");
  }



  // Jakob
  public void createMember() {
    // TODO switch


  }

  public void createPassivMember() {
    String name;
    int age;
    String email;
    Date date;

    // TODO Vent til UI er færdig

    //member.add(new PassiveMember(name, age, email, date));



  }




  // Jakob
  public void deleteMember() {
    boolean active = false;

    System.out.println("Enter your ID: ");
    while (!active) {
      for (int i = 0; i < members.size(); i++) {

        System.out.println("Are you sure you want to delete it \n" + members.get(i));
        System.out.println("y/n");


      }
    }



  }

}
