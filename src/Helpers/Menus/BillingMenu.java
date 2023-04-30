package Helpers.Menus;

public class BillingMenu extends Menu {
    public BillingMenu() {
        System.out.println("Choose Preferred Billing Method");
        addOption("Cash on Delivery");
        addOption("Credit Card");
        addOption("Bank Transfer");
    }
}
