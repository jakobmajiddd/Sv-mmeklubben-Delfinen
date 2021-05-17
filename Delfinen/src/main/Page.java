package main;

/**
 * @author Martin
 */

public class Page {
    public static Menu mainMenu;
    public static Menu adminMenu;
    public static Menu financeMenu;
    public static Menu memberCreationMenu;
    public static Menu competitiveMenu;
    public static Menu teamMenu;

    public Page() {
        setupMainMenu();
        setupAdministrativeMenu();
        setupFinanceMenu();
        setupCreationMenu();
        setupCompetitiveMenu();
        setupTeamMenu();
    }

    void setupMainMenu() {
        String[] mainMenuItems = new String[4];
        mainMenuItems[0] = "1. Administrative";
        mainMenuItems[1] = "2. Finance";
        mainMenuItems[2] = "3. Competitive";
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
        String[] financeMenuItems = new String[5];
        financeMenuItems[0] = "1. View total yearly revenue";
        financeMenuItems[1] = "2. View subtotal revenue from every member type";
        financeMenuItems[2] = "3. Update members payment date";
        financeMenuItems[3] = "4. Find unpaid members";
        financeMenuItems[4] = "9. Back";
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

    void setupCompetitiveMenu() {
        String[] competitiveMenuItems = new String[4];
        competitiveMenuItems[0] = "1. Junior Team";
        competitiveMenuItems[1] = "2. Senior Team";
        competitiveMenuItems[2] = "3. Competitions";
        competitiveMenuItems[3] = "9. Back";
        competitiveMenu = new Menu("Competitive menu", "Choose: ", competitiveMenuItems);
    }

    static void setupTeamMenu() {
        String[] teamMenuItems = new String[5];
        teamMenuItems[0] = "1. View students";
        teamMenuItems[1] = "2. Top students";
        teamMenuItems[2] = "3. Assign student to competition";
        teamMenuItems[3] = "4. Change students best time";
        teamMenuItems[4] = "9. Back";
        teamMenu = new Menu("Team Menu", "Choose: ", teamMenuItems);
    }
}
