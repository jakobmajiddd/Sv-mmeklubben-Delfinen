package main;

import member.Member;
import member.PassiveMember;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TEST {

    static UI ui = new UI();

    public static void main(String[] args) throws ParseException {

        Member member = new PassiveMember("Jens", 29, "jenner@gmaild.,.");
        memberSetDate(member);
        System.out.println(memberHasPaid(member));

    }

    public static void memberSetDate(Member member) {
        Calendar c = Calendar.getInstance();
        c.setTime(Calendar.getInstance().getTime());
        c.add(Calendar.DATE, 365);

        member.setNextPaymentDate(c.getTime());

    }

    public static boolean memberHasPaid(Member member) {
        Date c = Calendar.getInstance().getTime();
        return !c.after(member.getNextPaymentDate());
    }
}
