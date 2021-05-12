package main;

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

    public void printMainMenu(){
        System.out.println("Main menu -Exit with 9");
        System.out.println("1. Adminestration");
        System.out.println("2. Finanses");
        System.out.println("9. Quit");
    }
    public void printAdminMenu(){
        System.out.println("Adminestration Menu");
        System.out.println("1. Add member");
        System.out.println("2. Delete member");
        System.out.println("3. Print memberlist");
        System.out.println("9. Quit");
    }

    public void printFinanses(){
        System.out.println("Finanse Menu");
        System.out.println("");
    }
}
