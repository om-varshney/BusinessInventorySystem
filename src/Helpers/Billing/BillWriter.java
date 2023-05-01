package Helpers.Billing;

import Helpers.GetProduct;
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
        for (int orderID: orders) {
            this.products.add(GetProduct.getProduct(orderID));
        }
    }
    public String toString() {
        int count = 1;
        AsciiTable at = new AsciiTable();
        at.addRule();
        AT_Row invoiceTitle = at.addRow(null, null, "INVOICE FOR " + this.userID);
        invoiceTitle.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.addRow("S.N0", "Description", "Price");
        at.addRule();
        for (Product product: this.products) {
            at.addRow(count, product.getProductName(), product.getProductPrice());
            at.addRule();
            count++;
        }
        at.addRow(null, null, "Total Bill = " + this.totalBill);
        at.addRule();
        AT_Row paymentHeader = at.addRow(null, null, "Payment Information: ");
        paymentHeader.setTextAlignment(TextAlignment.CENTER);
        at.addRule();
        at.addRow("CC No.", "Bank Account No.", "IFSC CODE");
        at.addRule();
        at.addRow(
                Objects.requireNonNullElse(this.billingService.cardNumber(), "NA"),
                Objects.requireNonNullElse(this.billingService.accountNumber(), "NA"),
                Objects.requireNonNullElse(this.billingService.IFSCCode(), "NA")
        );
        at.addRule();
        return at.render();
    }
}
