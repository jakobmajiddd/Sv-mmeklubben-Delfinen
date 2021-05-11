package member;

import java.util.Date;

public class PassiveMember extends Member {
    PassiveMember(String name, int age, String email, String date) {
        super("pm", name, age, email, date);
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
