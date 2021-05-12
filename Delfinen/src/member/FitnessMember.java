package member;

public class FitnessMember extends Member {
    public FitnessMember(String name, int age, String email, String date) {
        super("fm", name, age, email, date);
    }

    public FitnessMember(String name, int age, String email) {
        super("fm", name, age, email);
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
