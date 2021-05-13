package main;

import java.util.Scanner;

public class Menu {
  private String menuHeader;
  private String leadText;
  private String[] menuItems;

  public Menu(String menuHeader, String leadText, String[] menuItems) {
    this.menuHeader = menuHeader;
    this.leadText = leadText;
    this.menuItems = menuItems;
  }

  public void printMenu() {
    System.out.println(menuHeader);
    for (String s : menuItems) {
      System.out.println(s);
    }
    System.out.print(leadText);
  }

  // move to UI
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
