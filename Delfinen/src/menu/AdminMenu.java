package menu;

public class AdminMenu extends Menu {
    public AdminMenu() {
        String[] menuItems = new String[4];
        menuItems[0] = "1. Add member";
        menuItems[1] = "2. Remove member";
        menuItems[2] = "3. Show members";
        menuItems[3] = "9. Back";
        setMenuItems(menuItems);
        setMenuHeader("Admin Menu");
        setLeadText("Choose: ");
    }
}
