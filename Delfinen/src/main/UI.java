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
        System.out.println("9. Return to main menu");
    }

    public void printFinanceMenu(){
        System.out.println("Finance Menu");
        System.out.println("1. Access yearly expected revenue");
        System.out.println("2. Access expected revenue for passive members");
        System.out.println("3. Access expected revenue for junior members");
        System.out.println("4. Access expected revenue for senior members");
        System.out.println("5. Access expected revenue for discounted members");
        System.out.println("6. Show members in arrears");
        System.out.println("9. Return to main menu");
    }
    public void printCreatMemberMenu(){
        System.out.println("What kind of menber would u like to create?");
        System.out.println("1. Passiv member");
        System.out.println("2. Fitness member");
        System.out.println("3. Competitive member");
        System.out.println("9. Return to main menu");
    }
    public void printCoachMenu(){
        System.out.println("Coach Menu");
        System.out.println("1. Add swim time to member");
        System.out.println("2. Pull top 5 senior swimmers for competition");
        System.out.println("3. Pull top 5 junior swimmers for competition");
        System.out.println("4. Add competition");
        System.out.println("9. Return to main menu");
    }
}
