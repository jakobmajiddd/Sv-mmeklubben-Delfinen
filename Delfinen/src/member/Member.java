package member;

// @author Martin

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Member {
    private final String FILE_ID;
    private final String NAME;
    private final int AGE;
    private final String EMAIL;
    private String lastPaymentDate;
    private int ID = count;
    private static int count;

    // sets lastPaymentDate to the date object was created.
    Member(String fileID, String name, int age, String email) {
        this.FILE_ID = fileID;
        this.NAME = name;
        this.AGE = age;
        this.EMAIL = email;
        setDateToday();
        count++;
        ID = count;
    }

    // used when loading from file
    Member(int ID, String fileID, String name, int age, String email, String date) {
        this.ID = ID;
        this.FILE_ID = fileID;
        this.NAME = name;
        this.AGE = age;
        this.EMAIL = email;
        this.lastPaymentDate = date;

    }

    public abstract String toFileFormat();

    public void setDateToday() {
        DateFormat df = new SimpleDateFormat("d/MM/y");
        Date today = Calendar.getInstance().getTime();
        lastPaymentDate = df.format(today);
    }

    public String getFILE_ID() {
        return FILE_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public int getAGE() {
        return AGE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getLastPaymentDate() {
        return lastPaymentDate;
    }

    public int getID() {
        return ID;
    }
}
