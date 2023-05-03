package Helpers.Menus;

public class AdminMenu extends Menu {
    public AdminMenu() {
        setName("Admin Menu");
        addOption("View Customer Details");
        addOption("View Orders");
        addOption("View Critical Products");
        addOption("Replenish Critical Products");
        addOption("Exit");
    }
}
