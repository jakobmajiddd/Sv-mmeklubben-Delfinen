package member;

/**
 * @author Martin
 */

public class FitnessMember extends Member {
    public FitnessMember(String name, int age, String email) {
        super("FM", name, age, email);
    }

    // File loading
    public FitnessMember(int ID, String name, int age, String email, String date) {
        super(ID, "FM", name, age, email, date);
    }

    @Override
    public String toFileFormat() {
        return getID()
        + "_" + getFILE_ID()
                + "_" + getNAME()
                + "_" + getAGE()
                + "_" + getEMAIL()
                + "_" + dateFormatted();
    }
}
