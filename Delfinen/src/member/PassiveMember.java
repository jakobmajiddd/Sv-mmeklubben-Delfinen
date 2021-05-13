package member;

public class PassiveMember extends Member {
    public PassiveMember(String name, int age, String email) {
        super("pm", name, age, email);
    }

    // File loading
    public PassiveMember(int ID, String name, int age, String email, String date) {
        super(ID, "pm", name, age, email, date);
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
