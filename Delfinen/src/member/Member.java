package member;

/**
 * @author Martin
 */

import UI.UI;
import files.FileFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Member implements FileFormat {
    private final UI UI = new UI();
    private final String FILE_ID;
    private final String NAME;
    private final int AGE;
    private final String EMAIL;
    private Date nextPaymentDate;
    private final int ID;

    // sets nextPaymentDate to the date object was created.
    Member(String fileID, String name, int age, String email) {
        this.FILE_ID = fileID;
        this.NAME = name;
        this.AGE = age;
        this.EMAIL = email;
        setDate();
        ID = UI.getValidMemberID();
    }

    // used when loading from file
    Member(int ID, String fileID, String name, int age, String email, String date) {
        this.ID = ID;
        this.FILE_ID = fileID;
        this.NAME = name;
        this.AGE = age;
        this.EMAIL = email;
        this.nextPaymentDate = convertStringToDate(date);
    }

    @Override
    abstract public String toFileFormat();

    public void setDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(Calendar.getInstance().getTime());
        c.add(Calendar.DATE, 365);
        setNextPaymentDate(c.getTime());
    }

    public String dateFormatted() {
        DateFormat df = new SimpleDateFormat("dd/MM/y");
        return df.format(nextPaymentDate);
    }

    private Date convertStringToDate(String sDate) {
        try {
            return new SimpleDateFormat("dd/MM/y").parse(sDate);
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

    public int getAGE() {
        return AGE;
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
        return "ID: #" + ID + ", Name: " + NAME + ", Age: " + AGE + " - Next payment date: " + dateFormatted() + " -> Type: " + FILE_ID;
    }
}
