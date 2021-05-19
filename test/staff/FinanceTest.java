package staff;

import competition.Discipline;
import member.CompetitiveMember;
import member.FitnessMember;
import member.Member;
import member.PassiveMember;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FinanceTest {
    private int passiveSubscription = 500;
    private int juniorSubscription = 1000;
    private double seniorSubscription = 1600;
    private double seniorDiscountedSubscription = 1600 * 0.75;

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

    @org.junit.jupiter.api.Test
    void expectedRevenue() {
        // Act
        ArrayList<Member> members = new ArrayList<>();
        PassiveMember passiveMember = new PassiveMember("jabok",22,"!dhdgd");
        FitnessMember fitnessMember = new FitnessMember("alex",33,"gwstgeg");
        CompetitiveMember competitiveMember = new CompetitiveMember("martin",34,"gegh", Discipline.CRAWL);
        members.add(passiveMember);
        members.add(fitnessMember);
        members.add(competitiveMember);

        // Actual
        double total = 0;
        for (Member m : members) {
            total += getType(m);
        }

        // Arrange
        double expected = 3700;

        // Assert
        assertEquals(expected, total);




    }
}