package member;

/**
 * @author Martin
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Member {
    private final String FILE_ID;
    private final String NAME;
    private int age;
    private final String EMAIL;
    private Date nextPaymentDate;
    private final int ID;
    private static int count;

    // sets lastPaymentDate to the date object was created.
    Member(String fileID, String name, int age, String email) {
        this.FILE_ID = fileID;
        this.NAME = name;
        this.age = age;
        this.EMAIL = email;
        setDate();
        count++;
        ID = count;
    }

    // used when loading from file
    Member(int ID, String fileID, String name, int age, String email, String date) {
        this.ID = ID;
        this.FILE_ID = fileID;
        this.NAME = name;
        this.age = age;
        this.EMAIL = email;
        this.nextPaymentDate = convertStringToDate(date);
        count++;
    }

    public abstract String toFileFormat();

    public void setDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(Calendar.getInstance().getTime());
        c.add(Calendar.DATE, 365);
        setNextPaymentDate(c.getTime());
    }

    public String dateFormatted() {
        DateFormat df = new SimpleDateFormat("d/MM/y");
        return df.format(nextPaymentDate);
    }

    public Date convertStringToDate(String sDate) {
        try {
            return new SimpleDateFormat("d/MM/y").parse(sDate);
        } catch (ParseException e) {
            return Calendar.getInstance().getTime();
        }
    }

    public String getFILE_ID() {
        return FILE_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public int getAge() {
        return age;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setNextPaymentDate(Date nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public Date getNextPaymentDate() {
        return nextPaymentDate;
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return "ID: #" + ID + ", Name: " + NAME + ", Age: " + age + " - Next payment date: " + dateFormatted() + " -> Type: " + FILE_ID;
    }
}
