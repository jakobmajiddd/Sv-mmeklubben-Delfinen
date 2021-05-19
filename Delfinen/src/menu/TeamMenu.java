package menu;

public class TeamMenu extends Menu{
    public TeamMenu() {
        String[] menuItems = new String[5];
        menuItems[0] = "1. View students";
        menuItems[1] = "2. Top students";
        menuItems[2] = "3. Assign student to competition";
        menuItems[3] = "4. Change students best time";
        menuItems[4] = "9. Back";
        setMenuItems(menuItems);
        setMenuHeader("Team Menu");
        setLeadText("Choose: ");
    }
}
