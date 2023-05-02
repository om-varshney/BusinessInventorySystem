package Helpers.Billing;

import Exceptions.ProductUnavailableException;
import Helpers.DateTimeHelper;
import Helpers.GetProduct;
import Helpers.PrettyPrint;
import Interfaces.Billing;
import Product.Product;
import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.Objects;

public class BillWriter {
    private final ArrayList<Product> products = new ArrayList<>();
    private final int userID;
    private final double totalBill;
    private final Billing billingService;
    public BillWriter(int userID, ArrayList<Integer> orders, double totalBill, Billing billingService) {
        this.userID = userID;
        this.totalBill = totalBill;
        this.billingService = billingService;
        this.fetchProducts(orders);
    }
    public void fetchProducts(ArrayList<Integer> orders) {
        Product currentProduct;
        for (int orderID: orders) {
            try {
                currentProduct = GetProduct.getProduct(orderID);
                this.products.add(currentProduct);
            } catch (ProductUnavailableException pue) {
                assert true;
            }
        }
    }
    public String toString() {
        if (this.products.size() == 0) {
            return PrettyPrint.printErrorMessage("No Valid Product for Billing.");
        }
        int count = 1;
        AsciiTable at = new AsciiTable();
        at.addRule();
        AT_Row invoiceTitle = at.addRow(null, null, null, null, "BUSINESS INVENTORY SYSTEM");
        invoiceTitle.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        AT_Row invoiceSubTitle = at.addRow(null, null, null, null, "INVOICE FOR USER ID: " + this.userID);
        invoiceSubTitle.setTextAlignment(TextAlignment.CENTER);
        at.addRow(null, null, null, null, DateTimeHelper.getCurrentDate());
        at.addRule();
        at.addRow("S.N0", "Description", "Price", "Shipping Cost", "Tax");
        at.addRule();
        for (Product product: this.products) {
            at.addRow(
                    count,
                    product.getProductName(),
                    product.getProductPrice(),
                    Math.round(product.getProductPrice() * product.getShippingCost()),
                    Math.round(product.getProductPrice() * product.getTaxPercentage())
            );
            at.addRule();
            count++;
        }
        at.addRow(null, null, null, null, "Total Bill = " + Math.round(this.totalBill));
        at.addRule();
        AT_Row paymentHeader = at.addRow(null, null, null, null, "Payment Information: ");
        paymentHeader.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.addRow(null, "CC No.", null, "Bank Account No.", "IFSC CODE");
        at.addRule();
        at.addRow(
                null,
                Objects.requireNonNullElse(this.billingService.cardNumber(), "NA"),
                null,
                Objects.requireNonNullElse(this.billingService.accountNumber(), "NA"),
                Objects.requireNonNullElse(this.billingService.IFSCCode(), "NA")
        );
        at.addRule();
        return at.render();
    }
}
