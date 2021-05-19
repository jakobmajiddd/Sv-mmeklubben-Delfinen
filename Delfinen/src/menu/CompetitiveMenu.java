package menu;

public class CompetitiveMenu extends Menu {
    public CompetitiveMenu() {
        String[] menuItems = new String[4];
        menuItems[0] = "1. Junior Team";
        menuItems[1] = "2. Senior Team";
        menuItems[2] = "3. Competitions";
        menuItems[3] = "9. Back";
        setMenuItems(menuItems);
        setMenuHeader("Competitive Menu");
        setLeadText("Choose: ");
    }
}
