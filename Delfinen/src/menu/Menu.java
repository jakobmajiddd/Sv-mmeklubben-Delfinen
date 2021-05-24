package menu;

import UI.UI;

public abstract class Menu {
  private final UI UI = new UI();
  private String menuHeader;
  private String leadText;
  private String[] menuItems;

  public void printMenu() {
    UI.display(menuHeader);
    for (String s : menuItems) {
     UI.display(s);
    }
    UI.displayAppend(leadText);
  }

  public void setMenuHeader(String menuHeader) {
    this.menuHeader = menuHeader;
  }

  public void setLeadText(String leadText) {
    this.leadText = leadText;
  }

  public void setMenuItems(String[] menuItems) {
    this.menuItems = menuItems;
  }
}
