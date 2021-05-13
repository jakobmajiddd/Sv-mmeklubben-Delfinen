package main;

import java.util.Scanner;

public class Menu {
  UI ui = new UI();
  private String menuHeader;
  private String leadText;
  private String[] menuItems;

  public Menu(String menuHeader, String leadText, String[] menuItems) {
    this.menuHeader = menuHeader;
    this.leadText = leadText;
    this.menuItems = menuItems;
  }

  public void printMenu() {
    ui.getMessege(menuHeader);
    for (String s : menuItems) {
     ui.getMessege(s);
    }
    ui.getMessege(leadText);
  }

}
