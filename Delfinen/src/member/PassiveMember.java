package member;

import java.util.Date;

public class PassiveMember extends Member {
    public PassiveMember(String name, int age, String email, Date date) {
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
