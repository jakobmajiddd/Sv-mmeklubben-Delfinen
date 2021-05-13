package main;
// @author Alexander
import java.util.Scanner;

public class UI {
    Scanner scan = new Scanner(System.in);


    public void incoraktOption(){
        System.out.println("Not a vailed number/command");
        System.out.println("Pleas try agein");
    }

    public int getInputNumber(){
        int inputNumber = scan.nextInt();
        scan.nextLine();
        return inputNumber;
    }
    public String getInputText(){
        String inputText = scan.toString();
        scan.nextLine();
        return inputText;
    }

    public String getMessege(String msg){
        return msg;
    }



    public static int getValidInt(String errorMsg) {
        Scanner in = new Scanner(System.in);

        boolean valid = false;
        int choice = 0;
        while (!valid) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                valid = true;
            } else {
                in.next();
                System.out.println(errorMsg);
            }
        }
        return choice;
    }

    public static int validateChoice(int r1, int r2, int quit, String errorMsg) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        boolean inRange = false;

        while (!inRange) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                if (choice >= r1 && choice <= r2 || choice == quit) {
                    inRange = true;
                } else {
                    System.out.println(errorMsg);
                }
            } else {
                System.out.println(errorMsg);
                in.next();
            }
        }
        return choice;
    }
}
