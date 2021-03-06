package member;

/**
 * @author Martin
 */

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
        return getID()
                + "_" + getFILE_ID()
                + "_" + getNAME()
                + "_" + getAGE()
                + "_" + getEMAIL()
                + "_" + dateFormatted();
    }
}
