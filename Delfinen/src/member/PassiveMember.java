package member;

public class PassiveMember extends Member {
    public PassiveMember(String name, int age, String email, String date) {
        super("pm", name, age, email, date);
    }

    public PassiveMember(String name, int age, String email) {
        super("pm", name, age, email);
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
