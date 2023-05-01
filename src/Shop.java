import Admin.AdminView;
import Helpers.Billing.BillWriter;
import Helpers.GetProduct;
import Helpers.Menus.AdminMenu;
import Helpers.Menus.BillingMenu;
import Helpers.Menus.LoginMenu;
import Helpers.Menus.MainMenu;
import Interfaces.Billing;
import Product.Product;
import Billing.COD;
import Billing.CreditCard;
import Billing.BankTransfer;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private final LoginMenu lm = new LoginMenu();
    private final MainMenu mm = new MainMenu();
    private final BillingMenu bm = new BillingMenu();
    private final AdminMenu am = new AdminMenu();
    private final AdminView av = new AdminView();
    private final Scanner sc = new Scanner(System.in);

    public Shop() {
        System.out.println("Welcome to our Inventory Management System. Please Login to continue");
    }
    public int authenticate() {
        int userID = 0;  // userID = 0 means unauthenticated.
        while (userID == 0) {
            System.out.println(lm);
            int lmChoice = lm.getChoice();
            switch (lmChoice) {
                case 1 -> {
                    System.out.print("Enter Username: ");
                    String userName = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();
                    userID = User.login(userName, password);
                }
                case 2 -> {
                    System.out.print("Enter Username: ");
                    String userName = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Distance: ");
                    int distance = sc.nextInt();
                    User user = new User(userName, password, phoneNumber, email, distance);
                    userID = user.signup();
                }
            }}
        return userID;
    }

    public void mainLoop(int userID) {
        int currentLoggedUser = userID;
        while (true) {
            System.out.println(mm);
            int mmChoice = mm.getChoice();
            switch (mmChoice) {
                case 1 -> {
                    currentLoggedUser = this.authenticate();
                }
                case 2 -> {
                    System.out.println("Here is a list of all our products");
                    GetProduct.displayAllProducts();
                }
                case 3 -> {
                    Billing billingMethod = new COD();
                    System.out.println("Please Provide a list of products that you would like to buy. (comma separated)");
                    String choices = sc.nextLine();
                    String[] stringArray = choices.split(",");
                    ArrayList<Integer> intList = new ArrayList<>();
                    for (String s : stringArray) {
                        try {
                            intList.add(Integer.parseInt(s.trim()));
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid input.");
                        }
                    }
                    if (intList.size() > 0) {
                        System.out.println("Please Choose mode of Payment");
                        System.out.println(bm);
                        int bmChoice = bm.getChoice();
                        switch (bmChoice) {
                            case 1 -> {
                                System.out.println("Cash on Delivery Set");
                            }
                            case 2 -> {
                                System.out.print("Enter Credit Card Number: ");
                                String ccNumber = sc.nextLine();
                                billingMethod = new CreditCard(ccNumber);
                                System.out.println("Credit Card Payment Set");
                            }
                            case 3 -> {
                                System.out.print("Enter Account Number: ");
                                String accNumber = sc.nextLine();
                                System.out.print("Enter IFSC Code: ");
                                String IFSCCode = sc.nextLine();
                                billingMethod = new BankTransfer(accNumber, IFSCCode);
                                System.out.println("Bank Transfer Payment Set");
                            }
                        }
                        Order order = new Order(
                                intList,
                                billingMethod,
                                currentLoggedUser
                        );
                        double bill = order.calculateBill();
                        BillWriter bw = new BillWriter(userID, intList, bill, billingMethod);
                        System.out.println(bw);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Admin Password: ");
                    String password = sc.nextLine();
                    if (!password.equals("Admin123")) {
                        System.out.println("Sorry You do not have Clearance");
                        break;
                    }
                    System.out.println("Welcome to Admin View");
                    System.out.println(am);
                    int amChoice = am.getChoice();
                    switch (amChoice) {
                        case 1 -> {
                            System.out.println("Here is a list of All orders");
                            av.viewOrders();
                        }
                        case 2 -> {
                            System.out.println("Here is a list of Critical Products");
                            av.viewCriticalProducts();
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Thank-you for Visiting");
                    return;
                }
            }
        }
    }

    public void go() {
        int userID = this.authenticate();
        System.out.println("Welcome ID: " + userID);
        this.mainLoop(userID);
    }
}
