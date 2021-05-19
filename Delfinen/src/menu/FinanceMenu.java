package menu;

public class FinanceMenu extends Menu {
    public FinanceMenu() {
        String[] menuItems = new String[4];
        menuItems[0] = "1. View total yearly revenue";
        menuItems[1] = "2. Update members payment date";
        menuItems[2] = "3. Find unpaid members";
        menuItems[3] = "9. Back";
        setMenuItems(menuItems);
        setMenuHeader("Finance Menu");
        setLeadText("Choose: ");
    }
}
