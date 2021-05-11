package main;

import java.util.Scanner;

public class UI {
    Scanner scan = new Scanner(System.in);


    public void incoraktOption(){
        System.out.println("Not a vailed number/command");
        System.out.println("Pleas try agein");
    }

    public int getInput(){
        int inputNumber = scan.nextInt();
        scan.nextLine();
        return inputNumber;
    }

    public String getMessege(String msg){
        System.out.println(msg);
        return msg;
    }

    public void printMainMenu(){
        System.out.println("Main menu -Exit with 9");
        System.out.println("1. Chairman");
        System.out.println("2. Accountant");
        System.out.println("3 Coach");
    }
}
