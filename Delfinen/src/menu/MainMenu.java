package menu;

public class MainMenu extends Menu {
    public MainMenu() {
        String[] menuItems = new String[4];
        menuItems[0] = "1. Administrative";
        menuItems[1] = "2. Finance";
        menuItems[2] = "3. Competitive";
        menuItems[3] = "9. Quit";
        setMenuItems(menuItems);
        setMenuHeader("Main Menu");
        setLeadText("Choose: ");
    }
}
