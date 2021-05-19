package menu;

public class CompetitionMenu extends Menu {
    public CompetitionMenu() {
        String[] menuItems = new String[6];
        menuItems[0] = "1. View competitions";
        menuItems[1] = "2. View competitors";
        menuItems[2] = "3. Create competition";
        menuItems[3] = "4. Remove competition";
        menuItems[4] = "5. Evaluate competition";
        menuItems[5] = "9. Back";
        setMenuItems(menuItems);
        setMenuHeader("Competition Menu");
        setLeadText("Choose: ");
    }
}
