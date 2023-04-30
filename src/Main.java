import Helpers.Menus.AdminMenu;
import Helpers.Menus.LoginMenu;
import Helpers.Menus.MainMenu;
import Product.Product;

public class Main {
    public static void main(String[] args) {
        Product.displayAllProducts();
        LoginMenu lm = new LoginMenu();
        System.out.println(lm);
//        int lmChoice = lm.getChoice();
//        System.out.println(lmChoice);

        MainMenu mm = new MainMenu();
        System.out.println(mm);
//        int mmChoice = mm.getChoice();
//        System.out.println(mmChoice);

        AdminMenu am = new AdminMenu();
        System.out.println(am);
//        int amChoice = am.getChoice();
//        System.out.println(amChoice);

        int id = User.login("Ishaan", "password789");
        System.out.println("userID " + id);
    }
}