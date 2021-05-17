package main;

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
    ui.display(menuHeader);
    for (String s : menuItems) {
     ui.display(s);
    }
    ui.displayAppend(leadText);
  }
}
