import Helpers.LoginMenu;
import Product.Product;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, world!");
//        Product.displayAllProducts();
        LoginMenu lm = new LoginMenu();
        System.out.println(lm);
        int choice = lm.getChoice();
        System.out.println(choice);
    }
}