package menu;

public class CreationMenu extends Menu {
    public CreationMenu() {
        String[] menuItems = new String[4];
        menuItems[0] = "1. Passive member";
        menuItems[1] = "2. Fitness member";
        menuItems[2] = "3. Competitive member";
        menuItems[3] = "9. Back";
        setMenuItems(menuItems);
        setMenuHeader("Creation Menu");
        setLeadText("Choose: ");
    }
}
