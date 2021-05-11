package member;

import competition.Competition;
import staff.Coach;

import java.util.ArrayList;
import java.util.Date;

public class TEST {
    public static void main(String[] args) {
        Member m = new CompetitiveMember("marty", 24, "as.com", new Date(), new Coach(), new Competition());
        System.out.println(m.toFileFormat());
        ArrayList<Member> members = new ArrayList<>();
    }
}
