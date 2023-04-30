package Helpers.Menus;

public class MainMenu extends Menu {
    public MainMenu() {
        System.out.println("Choose from the following options");
        addOption("Go to login/signup menu");
        addOption("View products");
        addOption("Place order");
        addOption("Go to admin Menu");
    }
}
