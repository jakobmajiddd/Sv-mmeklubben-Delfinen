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

    Member(String id, String name, int age, String email, Date date) {
        this.FILE_ID = id;
        this.NAME = name;
        this.AGE = age;
        this.EMAIL = email;
        this.lastPaymentDate = convertDateToString(date);
    }

    public abstract String toFileFormat();

    public String convertDateToString(Date date) {
        DateFormat df = new SimpleDateFormat("d:MM:y");
        Date today = Calendar.getInstance().getTime();
        return df.format(today);
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
}
