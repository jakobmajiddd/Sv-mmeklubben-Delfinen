package main;

public class Page {
    public static Menu mainMenu;
    public static Menu adminMenu;
    public static Menu financeMenu;
    public static Menu memberCreationMenu;

    public Page() {
        setupMainMenu();
        setupAdministrativeMenu();
        setupFinanceMenu();
        setupCreationMenu();
    }

    void setupMainMenu() {
        String[] mainMenuItems = new String[4];
        mainMenuItems[0] = "1. Administrative";
        mainMenuItems[1] = "2. Finance";
        mainMenuItems[2] = "3. Competitions";
        mainMenuItems[3] = "9. Quit";
        mainMenu = new Menu("Main menu", "Choose: ", mainMenuItems);
    }

    void setupAdministrativeMenu() {
        String[] adminMenuItems = new String[4];
        adminMenuItems[0] = "1. Add member";
        adminMenuItems[1] = "2. Remove member";
        adminMenuItems[2] = "3. Show members";
        adminMenuItems[3] = "9. Back";
        adminMenu = new Menu("Admin menu", "Choose: ", adminMenuItems);
    }

    void setupFinanceMenu() {
        String[] financeMenuItems = new String[4];
        financeMenuItems[0] = "1. View total yearly revenue";
        financeMenuItems[1] = "2. View subtotal revenue from every member type";
        financeMenuItems[2] = "3. View members with unpaid subscriptions";
        financeMenuItems[3] = "9. Back";
        financeMenu = new Menu("Finance menu", "Choose: ", financeMenuItems);
    }

    void setupCreationMenu() {
        String[] memberCreationItems = new String[4];
        memberCreationItems[0] = "1. Passive member";
        memberCreationItems[1] = "2. Fitness member";
        memberCreationItems[2] = "3. Competitive member";
        memberCreationItems[3] = "9. Back";
        memberCreationMenu = new Menu("Creation menu", "Choose: ", memberCreationItems);
    }
}
