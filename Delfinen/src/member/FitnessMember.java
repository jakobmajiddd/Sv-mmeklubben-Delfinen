package member;

import java.util.Date;

public class FitnessMember extends Member {
    FitnessMember(String name, int age, String email, Date date) {
        super("fm", name, age, email, date);
    }

    @Override
    public String toFileFormat() {
        return getFILE_ID()
                + "_" + getNAME()
                + "_" + getAGE()
                + "_" + getEMAIL()
                + "_" + getLastPaymentDate();
    }
}
