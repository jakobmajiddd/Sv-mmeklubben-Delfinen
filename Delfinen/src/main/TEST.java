package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TEST {
    public static void main(String[] args) throws ParseException {
        String date1 = "5/21/1997";
        String date2 = "7/21/1993";
        Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
        Date date4 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
        System.out.println(date3);

        System.out.println(date3.after(date4));
    }
}
