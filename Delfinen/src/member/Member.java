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

    Member(String id, String name, int age, String email) {
        this.FILE_ID = id;
        this.NAME = name;
        this.AGE = age;
        this.EMAIL = email;
        setDateToString();
    }

    Member(String id, String name, int age, String email, String date) {
        this.FILE_ID = id;
        this.NAME = name;
        this.AGE = age;
        this.EMAIL = email;
        this.lastPaymentDate = date;
    }

    public abstract String toFileFormat();

    public void setDateToString() {
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
}
