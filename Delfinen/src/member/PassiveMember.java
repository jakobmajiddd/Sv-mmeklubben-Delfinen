package member;

public class PassiveMember extends Member {
    public PassiveMember(String name, int age, String email) {
        super("PM", name, age, email);
    }

    // File loading
    public PassiveMember(int ID, String name, int age, String email, String date) {
        super(ID, "PM", name, age, email, date);
    }

    @Override
    public String toFileFormat() {
        return getFILE_ID()
                + "_" + getNAME()
                + "_" + getAge()
                + "_" + getEMAIL()
                + "_" + getLastPaymentDate();
    }
}
